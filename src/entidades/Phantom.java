package entidades;

import java.awt.Graphics;

import interfaz.Assets;
import interfaz.Game;

public class Phantom extends Enemy {
	
	public Phantom(Game game, float x, float y, int width, int height, char tileClass, int listPos) {
		super(game, x, y, width, height, tileClass, listPos);
		
	}

	@Override
	public void tick() {
		movePattern();
		move();
	}

	@Override
	public void render(Graphics graphics) {
		graphics.drawImage(Assets.phantom, (int)x, (int)y, null);
	}

}

