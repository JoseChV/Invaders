package entidades;

import java.awt.Graphics;
import java.awt.Rectangle;

import interfaz.Game;

/**
 * Entidades del juego
 * @author Jose Andres Ch
 *
 */
public abstract class Entity {
	
	protected float x, y;
	protected int width, height;
	protected Game game;
	public Rectangle bounds;
	
	protected float xMove, yMove;
	
	/**
	 * Constructor de una entidad
	 * @param game Juego
	 * @param x posicion en x
	 * @param y posicion en y
	 * @param width grosor del objeto
	 * @param height altura del objeto
	 */
	public Entity(Game game, float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.game = game;
		xMove = 0; 
		yMove = 0;
		
		this.bounds = new Rectangle(0,0,width,height);
		
	}
	/**
	 * Mueve el objeto
	 */
	public void move() {
		x += xMove; 
		y += yMove;
	}
	/**
	 * ACtualiza las variables del objeto
	 */
	public abstract void tick();
	/**
	 * Renderiza el objeto
	 * @param g Componente grafico
	 */
	public abstract void render(Graphics g);
	
	/**
	 * Obtiene la posicion en x
	 * @return float posicion
	 */
	public float getX() {
		return x;
	}
	/**
	 * Ingresa su nueva posicion en X
	 * @param x posicion
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * Obtiene la posicion en x
	 * @return float posicion
	 */
	public float getY() {
		return y;
	}
	/**
	 * Ingresa su nueva posicion en y
	 * @param y posicion
	 */
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width + (int)x;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height + (int)y;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	
}
	
