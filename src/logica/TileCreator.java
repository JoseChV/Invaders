package logica;

import java.awt.Graphics;
import java.util.Random;

import entidades.Enemy;
import interfaz.Game;
import interfaz.GameState;
/**
 * Controlador de las filas de enemigos
 * @author Jose Andres Ch
 *
 */
public class TileCreator {

	public Lista<Enemy> list;
	public int listX;
	public int listWidth;
	public int typeClass = -1;
	private Random random = new Random();
	private Nodo<Enemy> enemy1 = null, e = null;
	private Nodo<Enemy> enemy2 = null, e2 = null;
	public boolean destroyed;
	private Enemy boss;
	private EnemyFactory factory;
	private int size;
	private int specialCont = 0;
	private boolean change = false;
	private int numE, numE2, dest2;
	private GameState gameState;
	
	/**
	 * Constructor 
	 * @param game Juego
	 * @param gameState Estado del juego
	 */
	
	public TileCreator(Game game, GameState gameState) {
		this.factory = new EnemyFactory(game,this);
		this.gameState = gameState;
	}
	/**
	 * Crea una nueva fila de enemigos
	 * @param game Juego
	 */
	public void newTile(Game game) {
		typeClass+=1;
		if(typeClass== 6) {
			typeClass = 0;
		}
		
		size = 0;
		change = false;
		e = null;
		e2 = null;
		int x = 250;
		Lista<Enemy> lista;
		if(typeClass == 0) {
			lista = new ListaSimple<Enemy>();
		}else if(typeClass == 1) {
			lista = new ListaSimple<Enemy>();
		}else if(typeClass == 2) {
			lista = new ListaDoble<Enemy>();
		}else if(typeClass == 3) {
			lista = new ListaCirc<Enemy>();
		}else if(typeClass == 4) {
			lista = new ListaCirc<Enemy>();
		}else {
			lista = new ListaDobleCirc<Enemy>();
		}
		int cont = 0;
		if(typeClass != 5) {
			while(cont<7) {
				if(cont == 3 && typeClass != 0) {
					lista.add(factory.newEnemy("boss", x, 10, 0, 0));
					this.boss = factory.boss;
					x+=30;
				}else {
					lista.add(factory.newEnemy("menor", x, 75, 0, 0));
				}
				cont++;
				x += 120;
				size++;
			}
		}else {
			float radius = 14.0f;
			double angle = 0;
			x = 600;
			while(cont<5) {
				if(cont == 2 && typeClass != 0) {
					lista.add(factory.newEnemy("boss", x, 10, 0, angle));
				}else {
					lista.add(factory.newEnemy("menor", x, 75, radius, angle));
				}
				cont++;
				radius -= 7;
				angle+=90;
			}
		}
		
		this.list = lista;
		if(typeClass == 2) {
			for(Nodo<Enemy> e = list.getPrimero() ; e != null; e = e.getSiguiente()) {
				e.getValor().setSpeed(0.0f);
			}
		}
	}
	/**
	 * Elimina un enemigo de la lista.
	 * @param enemy Enemigo a borrar.
	 */
	public void remove(Enemy enemy) {
		gameState.score += 100;
		Nodo<Enemy> temp = list.getPrimero();
		boolean bool = false;
		if(typeClass <=2 ) {
			while(temp!=null) {
				bool = removeAux(enemy, temp, bool);
				temp = temp.getSiguiente();
			}
		}
		else {
			while(temp.getSiguiente() != list.getPrimero()) {
				bool = removeAux(enemy, temp, bool);
				temp = temp.getSiguiente();
			}
			bool = removeAux(enemy, temp, bool);
			if(temp.getValor().getFlag() == false) {
				temp.getValor().setSpeed(5.0f);
			}else {
				temp.getValor().setSpeed(2.0f);
			}

		}
		destroyed = true;
	}
	
	/**
	 * Funcion auxiliar para eliminar en enemigo.
	 * @param enemy Enemigo a borrar
	 * @param temp Nodo temporal de la lista
	 * @param bool Verdadero luego de eliminar el enemigo.
	 * @return bool
	 */

	private boolean removeAux(Enemy enemy, Nodo<Enemy> temp, boolean bool) {
		if(typeClass != 2) {

			if(temp.getValor() == enemy) {
				list.delete(enemy);
				bool = true;
				if(enemy == this.boss) {
					this.boss = null;
					gameState.score+=400;
					bossDeath();
				}
				size--;
				if(temp.getSiguiente()!= null) {
					enemy2 = temp.getSiguiente();
				}else {
					enemy2 = null;
				}
			}else if(bool == false) {
				if(temp.getValor().getFlag() == false) {
					temp.getValor().setSpeed(2.0f);
				}else {
					temp.getValor().setSpeed(5.0f);
				}
				enemy1 = temp;
			}else {
				if(temp.getValor().getFlag() == false) {
					temp.getValor().setSpeed(5.0f);
				}else {
					temp.getValor().setSpeed(2.0f);
				}
			}

		}else {
			if(temp.getValor() == enemy) {
				list.delete(enemy);
				bool = true;
				if(enemy == this.boss) {
					this.boss = null;
					bossDeath();
				}
				size--;
			}
		}
		if(bool) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * Accion a realizar cuando el jefe es destruido
	 */
	private void bossDeath() {
		if(typeClass == 1 || typeClass == 2) {
			for(Nodo<Enemy> b = list.getPrimero() ; b != null; b = b.getSiguiente()) {
				remove(b.getValor());
			}
			this.enemy1 = null;
			this.enemy2 = null;
			destroyed = false;
		}else if(typeClass == 3) {
			if(size <= 1) {
				destroyed = false;
			}else {
				boolean repeat = true;
				while(repeat == true) {
					int selected = random.nextInt(size);
					int cont = 0;
					if(size>=3) {
						for(Nodo<Enemy> b = list.getPrimero() ; b.getSiguiente() != list.getPrimero(); b = b.getSiguiente()) {
							if(cont == selected) {
								if(b.getValor() != boss) {
									boolean flag = b.getValor().getFlag();
									float x = b.getValor().getX();
									float y = b.getValor().getY()-60;
									b.setValor(factory.newEnemy("boss", (int) x, (int) y, 0, 0));
									b.getValor().setFlag(flag);
									this.boss = b.getValor();
									repeat = false;
								}
							}
							cont ++;
						}
					}else {
						repeat = false;
					}
				}
			}
		}
	}
	/**
	 * Elimina el espacio entre 2 naves luego de que una es destruida
	 * @param enemy1 Enemigo a la izquierda del destruido
	 * @param enemy2 Enemigo a la derecha del destruido
	 */
	public void getClose(Nodo<Enemy> enemy1, Nodo<Enemy> enemy2) {
		boolean primero = true;
		if((enemy1 ==null && enemy2 == null) || typeClass == 2) {
			destroyed = false;
			primero = false;
			
		}else if(enemy1 != null && enemy2 != null) {
			if(enemy2.getValor().getX()-enemy1.getValor().getWidth() < 60 || enemy2.getValor().getX()-enemy1.getValor().getWidth() > 900) {
				Nodo<Enemy> temp = list.getPrimero();
				while((temp!=null && temp.getSiguiente() != list.getPrimero())) {
					temp.getValor().setSpeed(4.0f);
					temp = temp.getSiguiente();
					primero = false;
				}
				if (temp != null) {
					temp.getValor().setSpeed(4.0f);
				}
				this.enemy1 = null;
				this.enemy2 = null;
				destroyed = false;
			}
		}else{
			Nodo<Enemy> temp = list.getPrimero();
			if(temp!=null) {

				while((temp!=null && temp != list.getPrimero()) || primero) {
					temp.getValor().setSpeed(4.0f);
					temp = temp.getSiguiente();
					primero = false;
				}
				if (temp != null) {
					temp.getValor().setSpeed(4.0f);
				}
				this.enemy1 = null;
				this.enemy2 = null;
				destroyed = false;
			}
		}
	}
	
	/**
	 * Mueve la fila de enemigos
	 */
	public void tileMove() {
		if(list.getPrimero()!= null) {

			if(typeClass!=2) {

				this.listX = (int)list.getPrimero().getValor().getX();
				this.listWidth = (int)list.getUltimo().getValor().getWidth();
				Nodo<Enemy> temp = list.getPrimero();
				if(listX<=100) {
					while(temp!= null && temp.getSiguiente() != list.getPrimero()) {
						temp.getValor().setFlag(true);
						temp = temp.getSiguiente();
					}
					if (temp != null) {
						temp.getValor().setFlag(true);
					}
				}else if(listWidth>=1200) {
					while(temp!=null && temp.getSiguiente() != list.getPrimero()) {
						temp.getValor().setFlag(false);
						temp = temp.getSiguiente();
					}
					if (temp != null) {
						temp.getValor().setFlag(false);
					}
				}
			}else {
				if(change) {
					if(e!= null && e2!= null && e != e2) {
						specialCont = 0;
						if(numE < numE2) {
							e.getValor().setSpeed(6.0f);
							e2.getValor().setSpeed(-6.0f);
							if(e.getValor().getX()> dest2) {
								e.getValor().setSpeed(0.0f);
								e2.getValor().setSpeed(0.0f);
								change = false;
								e = null;
								e2 = null;
							}
						}else if(numE > numE2) {
							e.getValor().setSpeed(-6.0f);
							e2.getValor().setSpeed(6.0f);
							if(e.getValor().getX()< dest2) {
								e.getValor().setSpeed(0.0f);
								e2.getValor().setSpeed(0.0f);
								change = false;
								e = null;
								e2 = null;
							} 

						}
					}else {
						change = false;
						e = null;
						e2 = null;
					}

				}else if(specialCont>20) {
					numE2 = random.nextInt(size);
					Nodo<Enemy> temp = list.getPrimero();
					int cont = 0;
					while(temp.getSiguiente() != null) {
						if(temp.getValor() == this.boss) {
							this.e = temp;
							numE = cont;
						}
						if (this.e2 == null) {
							if (cont == numE2) {
								this.e2 = temp;
								dest2 = (int) e2.getValor().getX();
							}
						}
						temp = temp.getSiguiente();
						cont ++;
					}
					specialCont = 0;
					change = true;
				}else {
					specialCont ++;
				}
			}
		}
	}
	/**
	 * Actualiza las variables de la fila de enemigos
	 */
	public void tick() {
		if(typeClass<=2) {
			for(Nodo<Enemy> b = list.getPrimero();b != null;b = b.getSiguiente() ) {
				b.getValor().tick();
			}
		}else {
			if(!list.empty()) {
				Nodo<Enemy> temp = list.getPrimero();
				while(temp.getSiguiente() != list.getPrimero()) {
					temp.getValor().tick();
					temp = temp.getSiguiente();
				}
				temp.getValor().tick();
			}
		}
		
		
		if(destroyed && typeClass != 5 && typeClass != 2) {
			getClose(enemy1,enemy2);
		}else {
			tileMove();
			if(typeClass == 4) {
				list.bubbleSort();
			}
			destroyed = false;
		}
	}
	/**
	 * Renderiza la fila de enemigos
	 * @param g componente grafico
	 */
	public void render(Graphics g) {
		if(typeClass<=2) {
			for(Nodo<Enemy> b = list.getPrimero();b != null;b = b.getSiguiente() ) {
				b.getValor().render(g);						
			}
		}else {
			Nodo<Enemy> temp = list.getPrimero();
			if (temp != null) {
				while(temp.getSiguiente() != list.getPrimero()) {
					temp.getValor().render(g);
					temp = temp.getSiguiente();
				}
				if(temp!= null) {
					
					temp.getValor().render(g);
				}
			}
		
		}
	}
	/**
	 * Retorna el tipo de fila de enemigos
	 * @return String fila de enemigos
	 */
	public String getTypeClassString() {
		if(typeClass == 0) {
			return "Basic";
		}else if(typeClass == 1) {
			return "Class A";
		}else if(typeClass == 2) {
			return "Class B";
		}else if(typeClass == 3) {
			return "Class C";
		}else if(typeClass == 4) {
			return "Class D";
		}else {
			return "Class E";
		}
	}

} 
