package interfaz;

import java.awt.Graphics;

import entidades.Bullet;
import logica.ListaSimple;
import logica.Nodo;
/**
 * Controlador de la balas
 * @author Jose Andres Ch
 *
 */
public class BulletControl {
	protected ListaSimple<Bullet> lista = new ListaSimple<Bullet>();
	protected Game game;
	
	/**
	 * Constructor
	 * @param game Juego
	 */
	public BulletControl(Game game) {
		this.game = game;
	}
	/**
	 * Añade una bala a la lista de balas
	 * @param x Posicion en el eje x
	 * @param y Posicion en el eje y
	 */
	public void addBullet( float x, float y) {
		lista.add(new Bullet(game, x, y, 19, 34));
	} 
	/**
	 * Borra la bala de la lista.
	 * @param bullet Bala a borrar.
	 */
	public void removeBullet(Bullet bullet) {
		lista.delete(bullet);
	} 
	/**
	 * Renderiza y actualiza variables de todas las balas
	 * @param g Componente grafico
	 */
	public void update(Graphics g) {
		for(Nodo<Bullet> b = lista.getPrimero();b != null;b = b.getSiguiente() ) {
			b.getValor().tick();
			b.getValor().render(g);
		}
	}
}

