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
	public int cont=0;
	private Game game;
	private Random random = new Random();
	
	public TileCreator(Game game) {
		this.game = game;
	}
	public void newRandomTypeClass() {
		this.typeClass = random.nextInt(6);
		System.out.println(typeClass);
	}
	
	public void newTile(Game game) {
		EnemyFactory factory = new EnemyFactory(game,this);
		newRandomTypeClass();
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
		while(cont<7) {
			if(cont == 3 && typeClass != 0) {
				lista.add(factory.newEnemy("boss", x, 10));
				x+=30;
			}else {
				lista.add(factory.newEnemy("menor", x, 75));
			}
			this.cont++;
			x += 120;
		}
		this.cont= 0;
		this.list = lista;
		System.out.println("build complete");
	}
	
	public void remove(Enemy enemy) {
		list.delete(enemy);
	}
	public void tileMove() {
		this.listX = (int)list.getPrimero().getValor().getX();
		this.listWidth = (int)list.getUltimo().getValor().getWidth();
		System.out.println(listWidth);
		Nodo<Enemy> temp = list.getPrimero();
		if(listX<=100) {
			while(temp!= null && temp.getSiguiente() != list.getPrimero()) {
				temp.getValor().setFlag(true);
				temp.getValor().tick();
				temp = temp.getSiguiente();
			}
		}else if(listWidth>=1200) {
			while(temp!=null && temp.getSiguiente() != list.getPrimero()) {
				temp.getValor().setFlag(false);
				temp.getValor().tick();
				temp = temp.getSiguiente();
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
		}
		if(list.empty()) {
			this.newTile(game);
		}else if(this.list.getPrimero().getValor().getY()>650) {
			this.newTile(game);
		}else {
			tileMove();
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
		
		}
	}

} 
