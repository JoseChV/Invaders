package entidades;

import java.awt.Graphics;

import interfaz.Assets;
import interfaz.Game;

public class Bullet extends Entity{

	protected float xMove, yMove;
	
	public Bullet(Game game, float x, float y, int width, int height) {
		super(game, x, y, width, height);
	}

	public void tick() {
		yMove = 9.0f;
		xMove = 0;
		move();
	} 

	public void render(Graphics graphics) {
		graphics.drawImage(Assets.PA, (int)x, (int)y, null); 

	}
	public void move() {
		y-=yMove;
	}

}
