package entidades;

import java.awt.Graphics;

import interfaz.Assets;
import interfaz.Game;
/**
 * Bala
 * @author Jose Andres Ch
 *
 */
public class Bullet extends Entity{

	protected float xMove, yMove;
	/**
	 * Crea una nueva bala
	 * @param game Juego
	 * @param x Posicion en x
	 * @param y Posicion en y
	 * @param width Grosor
	 * @param height Altura
	 */
	public Bullet(Game game, float x, float y, int width, int height) {
		super(game, x, y, width, height);
	}
	/**
	 * Actualiza sus variables
	 */
	public void tick() {
		yMove = 9;
		xMove = 0;
		move();
	} 

	/**
	 * Renderiza la bala
	 */
	public void render(Graphics graphics) {
		graphics.drawImage(Assets.PA, (int)x, (int)y, null); 

	}
	/**
	 * Mueve la bala
	 */
	public void move() {
		y-=yMove;
	}

}
