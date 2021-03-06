package entidades;

import java.awt.Graphics;

import interfaz.Assets;
import interfaz.BulletControl;
import interfaz.Game;
/**
 * Jugador
 * @author Jose Andres Ch
 *
 */
public class Player extends Ship{
	
	private BulletControl bc;
	private int attSpeed = 0;
	/**
	 * Crea el jugador
	 * @param game Juego
	 * @param x Posicion en x
	 * @param y Posicion en y
	 * @param width Grosor
	 * @param height Altura
	 * @param bc Controlador de balas
	 */
	public Player(Game game,float x, float y, int width, int height, BulletControl bc) {
		super(game, x, y, width, height);
		this.hp = 3;
		this.speed = 8;
		this.bc = bc;
		
	}
	
	/**
	 * ACtualiza sus variables
	 */
	@Override
	public void tick() {
		getInput();
		move();
	}
	/**
	 * Renderiza la nava
	 */
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int)x, (int)y, null);
		
	}
	/**
	 * Obtiene el input del teclado
	 */
	private void getInput() {
		xMove = 0;
		if(game.getKeyManager().left) {
			if(x<=0) {
				xMove = 0;
			}else {
				xMove = -speed;				
			}
		}
		if(game.getKeyManager().right) {
			if(x+width>=1300) {
				xMove = 0;
			}else {
				xMove = speed;				
			}
		}if(game.getKeyManager().space) {
			if(attSpeed%12 == 0) {
				bc.addBullet(this.x+26, this.y);
				attSpeed = 0;
			}
			attSpeed++;
		}else {
			attSpeed = 0;
		}
	}
	public float getX() {
		return x;
	}


	
}
