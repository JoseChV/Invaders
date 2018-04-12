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
	
	public void addBullet( float x, float y) {
		lista.add(new Bullet(game, x, y, 19, 34));
	} 
	
	public void removeBullet(Bullet bullet) {
		lista.delete(bullet);
	} 
	public void update(Graphics graphics) {
		for(Nodo<Bullet> b = lista.getPrimero();b != null;b = b.getSiguiente() ) {
			b.getValor().tick();
			b.getValor().render(graphics);
			if(b.getValor().getY()<-20) {
				this.removeBullet(b.getValor());
			}
		}
	}
	
}
