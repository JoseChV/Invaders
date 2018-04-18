package entidades;

import java.awt.Graphics;

import interfaz.Assets;
import interfaz.BulletControl;
import interfaz.Game;

public class Player extends Ship{
	
	private BulletControl bc;
	private int attSpeed = 0;

	public Player(Game game,float x, float y, int width, int height, BulletControl bc) {
		super(game, x, y, width, height);
		this.hp = 3;
		this.speed = 8;
		this.bc = bc;
		
	}

	@Override
	public void tick() {
		getInput();
		move();
	}
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int)x, (int)y, null);
		
	}
	
	private void getInput() {
		xMove = 0;
		if(game.getKeyManager().left) {
			xMove = -speed;
		}
		if(game.getKeyManager().right) {
			xMove = speed;
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
