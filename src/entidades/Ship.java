package entidades;

import interfaz.Game;
/**
 * Crea una nueva nave
 * @author Jose Andres Ch
 *
 */
public abstract class Ship extends Entity{
	
	protected int hp;
	protected float speed;
	
	
	
	/**
	 * Crea una nueva nave
	 * @param game Juego 
	 * @param x Posicion en x
	 * @param y Posicion en y
	 * @param width Grosor de la nave
	 * @param height Altura de la nave
	 */
	public Ship(Game game, float x, float y, int width, int height) {
		super(game, x, y, width, height);
		speed = 4.0f;
		
	
	}
	
	//Getters y setters
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	


}
