package logica;

import java.awt.Graphics;
import java.util.Random;

import entidades.Enemy;
import interfaz.Game;

public class TileCreator {

	public Lista<Enemy> list;
	public int listX;
	public int listWidth;
	public int typeClass = 0;
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
	
	public TileCreator(Game game) {
		this.factory = new EnemyFactory(game,this);
	}
	
	public void newTile(Game game) {
		size = 0;
		typeClass=2;
		int x = 300;
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
				angle += 90;
			}
		}
		
		this.list = lista;
		if(typeClass == 2) {
			for(Nodo<Enemy> e = list.getPrimero() ; e != null; e = e.getSiguiente()) {
				e.getValor().setSpeed(0.0f);
			}
		}
		//typeClass++;
	}

	public void remove(Enemy enemy) {
		Nodo<Enemy> temp = list.getPrimero();
		boolean bool = false;
		if(typeClass <=2 ) {
			while(temp!=null) {
				bool = removeAux(enemy, temp, bool);
				temp = temp.getSiguiente();
			}
		}else {
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
	


	private boolean removeAux(Enemy enemy, Nodo<Enemy> temp, boolean bool) {
		if(temp.getValor() == enemy) {
			list.delete(enemy);
			bool = true;
			if(enemy == this.boss) {
				this.boss = null;
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
		if(bool) {
			return true;
		}else {
			return false;
		}
	}


	private void bossDeath() {
		if(typeClass == 1 || typeClass == 2) {
			for(Nodo<Enemy> b = list.getPrimero() ; b != null; b = b.getSiguiente()) {
				remove(b.getValor());
			}
			this.enemy1 = null;
			this.enemy2 = null;
			destroyed = false;
		}else if(typeClass == 3) {
			if(size == 0) {
				destroyed = false;
			}else {
				int selected = random.nextInt(size);
				int cont = 0;
				for(Nodo<Enemy> b = list.getPrimero() ; b.getSiguiente() != list.getPrimero(); b = b.getSiguiente()) {
					boolean flag = b.getValor().getFlag();
					if(cont == selected) {
						float x = b.getValor().getX();
						float y = b.getValor().getY()-50;
						b.setValor(factory.newEnemy("boss", (int) x, (int) y, 0, 0));
						b.getValor().setFlag(flag);
						this.boss = b.getValor();
					}
					cont ++;
				
				}
			}
		}
		
	}
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
	
	public void tileMove() {
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
				numE = random.nextInt(size);
				numE2 = random.nextInt(size);
				System.out.println(numE + "  " + numE2);
				Nodo<Enemy> temp = list.getPrimero();
				int cont = 0;
				while(temp.getSiguiente() != null) {
					if(this.e == null) {
						if(cont == numE) {
							this.e = temp;
							dest1 = (int) e.getValor().getX();
						}
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
	
	public void tick() {
		if(typeClass<=2) {
			for(Nodo<Enemy> b = list.getPrimero();b != null;b = b.getSiguiente() ) {
				b.getValor().tick();
			}
		}else {
			Nodo<Enemy> temp = list.getPrimero();
			while(temp.getSiguiente() != list.getPrimero()) {
				temp.getValor().tick();
				temp = temp.getSiguiente();
			}
			temp.getValor().tick();
		}
		
		
		if(destroyed && typeClass != 5 && typeClass != 2) {
			getClose(enemy1,enemy2);
		}else {
			tileMove();
			destroyed = false;
		}
	}
	public void render(Graphics g) {
		if(typeClass<=2) {
			for(Nodo<Enemy> b = list.getPrimero();b != null;b = b.getSiguiente() ) {
				b.getValor().render(g);						
			}
		}else {
			Nodo<Enemy> temp = list.getPrimero();
			while(temp.getSiguiente() != list.getPrimero()) {
				temp.getValor().render(g);
				temp = temp.getSiguiente();
			}
			temp.getValor().render(g);
		
		}
	}

} 
