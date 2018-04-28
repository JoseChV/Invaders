package entidades;

import java.awt.Graphics;

import interfaz.Assets;
import interfaz.Game;
import logica.TileCreator;
/**
 * Crea un Phantom
 * @author Jose Andres Ch
 *
 */
public class Phantom extends Enemy {
	
	public static String type = "boss";
	/**
	 * Crea un Phantom
	 * @param game Juego
	 * @param tc Controlador de filas
	 * @param x Posicion en x
	 * @param y Posicion en Y
	 * @param width Grosor del phantom
	 * @param height Altura del phantom
	 * @param tileClass Tipo de fila en la que se encuentra
	 * @param radius radio
	 * @param angle angulo
	 */
	public Phantom(Game game, TileCreator tc, float x, float y, int width, int height, int tileClass, float radius, double angle) {
		super(type, game, tc, x, y, width, height, tileClass, radius, angle);
		this.hp = 5;
	}
	/**
	 * Actualiza sus variables
	 */
	@Override
	public void tick() {
		movePattern();
		move();
	}
	/**
	 * Renderiza la nave
	 */
	@Override
	public void render(Graphics graphics) {
		if(hp==1) {
			graphics.drawImage(Assets.destPhantom, (int)x, (int)y, null);
		}else {
			graphics.drawImage(Assets.phantom, (int)x, (int)y, null);	
		}
	}
	
}
