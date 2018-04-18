package interfaz;

import java.awt.Graphics;

import entidades.Bullet;
import logica.ListaSimple;
import logica.Nodo;

public class BulletControl {
	protected ListaSimple<Bullet> lista = new ListaSimple<Bullet>();
	protected Game game;
	
	public BulletControl(Game game) {
		this.game = game;
	}
	
	public void addBullet( float f, float y) {
		lista.add(new Bullet(game, f, y, 19, 34));
	} 
	
	public void removeBullet(Bullet bullet) {
		lista.delete(bullet);
	} 
	public void update(Graphics g) {
		for(Nodo<Bullet> b = lista.getPrimero();b != null;b = b.getSiguiente() ) {
			b.getValor().tick();
			b.getValor().render(g);
		}
	}
}

