package entidades;

import interfaz.Game;
import logica.TileCreator;
/**
 * Enemigo
 * @author Jose Andres Ch
 *
 */
public abstract class Enemy extends Ship{
	
	protected int tileClass;
	protected TileCreator tc;
	
	protected float speed;
	protected double angle = 0;
	protected float radius;
	protected boolean flag;
	
	protected int hp;
	public int cont= 0;
	
	
	/**
	 * Crea un nuevo enemigo
	 * @param type Tipo de enemigo
	 * @param game Juego
	 * @param tc Controlador de fila
	 * @param x Posicion en x
	 * @param y Posicion en y
	 * @param width Grosor
	 * @param height Altura
	 * @param tileClass Tipo de fila
	 * @param radius radio 
	 * @param angle angulo
	 */
	public Enemy(String type, Game game, TileCreator tc, float x, float y, int width, int height, int tileClass, float radius, double angle) {
		super(game, x, y, width, height);
		this.tileClass = tileClass;
		this.radius = radius;
		this.speed = 4.0f;
		this.angle = angle;
		
	}
	/**
	 * Patron de movimiento a seguir
	 */
	public void movePattern() {
		angle += 0.1;
		if(tileClass == 5) {
			x = (int)(Math.cos(angle)*radius)+x;
			y = (int)(Math.sin(angle)*radius)+ y;
			
		}else if(tileClass == 2){
			xMove = speed;
		}
		else {
			if(flag) {
				if(x<=0) {
					xMove = -speed;
				}else {
					xMove = speed;				
				}
			}else {
				if(width+x>=1300) {
					xMove = speed;
				}else {
					xMove = -speed;				
				}
			}
		}
		y += 0.4;
	}
	/**
	 * Golpea al enemigo
	 * @return Valor de golpear
	 */
	public boolean hit() {
		if(cont%50==0) {
			cont=0;
			this.setHp(hp-1);
			return true;
		}
		else {
			cont++;
			return false;
		}
	}
	// Getters y Setters
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public boolean getFlag() {
		return this.flag;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	@Override
	public int getHp() {
		return hp;
	}
	@Override
	public void setHp(int hp) {
		this.hp = hp;
	}
}


