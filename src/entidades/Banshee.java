package entidades;

import java.awt.Graphics;

import interfaz.Assets;
import interfaz.Game;
import logica.TileCreator;
public class Banshee extends Enemy{
	
	public static String type = "menor";
	/**
	 * Crea un Banshee
	 * @param game Juego
	 * @param tc Controlador de filas
	 * @param x Posicion en x
	 * @param y Posicion en Y
	 * @param width Grosor del banshee
	 * @param height Altura del banshee
	 * @param tileClass Tipo de fila en la que se encuentra
	 * @param radius radio
	 * @param angle angulo
	 */
	public Banshee(Game game, TileCreator tc, float x, float y, int width, int height, int tileClass, float radius, double angle) {
		super(type, game, tc, x, y, width, height, tileClass, radius, angle);
		this.hp = 3;
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
	 * renderiza la nave
	 */
	@Override
	public void render(Graphics g) {
		if(hp==1) {
			g.drawImage(Assets.destBanshee, (int)x, (int)y, null);
		}else {
			g.drawImage(Assets.banshee, (int)x, (int)y, null);	
		}
	}
	
}