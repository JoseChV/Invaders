package logica;

import java.awt.Graphics;

import entidades.Bullet;
import entidades.Enemy;
import interfaz.Game;

public class TileCreator {

	private Lista<Enemy> list;
	
	
	public Lista<Enemy> newTile(Game game , char typeClass) {
		EnemyFactory factory = new EnemyFactory(game);
		int cont = 1;
		int x = 300;
		if(typeClass == 'b') {
			this.list = new ListaSimple<Enemy>();
		}else if(typeClass == 'A') {
			this.list = new ListaSimple<Enemy>();
		}else if(typeClass == 'B') {
			this.list = new ListaDoble<Enemy>();
		}else if(typeClass == 'C') {
			this.list = new ListaCirc<Enemy>();
		}else if(typeClass == 'D') {
			this.list = new ListaCirc<Enemy>();
		}else {
			this.list = new ListaDobleCirc<Enemy>();
		}
		while(cont<8) {
			if(cont == 4 && typeClass != 'b') {
				list.add(factory.newEnemy("boss", x, 10, typeClass, cont));
				x+=30;
			}else {
				list.add(factory.newEnemy("menor", x, 75, typeClass, cont));
			}
			cont++;
			x += 130;
		}
		return list;
	}
	
	public void remove(Enemy enemy) {
		list.delete(enemy);
	}
	public void tick() {
		for(Nodo<Enemy> b = list.getPrimero();b != null;b = b.getSiguiente() ) {
			b.getValor().tick();
		}
	}
	public void render(Graphics graphics) {
		for(Nodo<Enemy> b = list.getPrimero();b != null;b = b.getSiguiente() ) {
			b.getValor().render(graphics);
		}
	}

}
