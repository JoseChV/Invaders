package entidades;

import java.awt.Graphics;

import interfaz.Assets;
import interfaz.Game;
import logica.TileCreator;

public class Phantom extends Enemy {
	
	public static String type = "boss";
	
	public Phantom(Game game, TileCreator tc, float x, float y, int width, int height, int tileClass, float radius, double angle) {
		super(type, game, tc, x, y, width, height, tileClass, radius, angle);
		this.hp = 5;
	}

	@Override
	public void tick() {
		movePattern();
		move();
	}

	@Override
	public void render(Graphics graphics) {
		if(hp==1) {
			graphics.drawImage(Assets.destPhantom, (int)x, (int)y, null);
		}else {
			graphics.drawImage(Assets.phantom, (int)x, (int)y, null);	
		}
	}
	
}
