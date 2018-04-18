package entidades;

import java.awt.Graphics;

import interfaz.Assets;
import interfaz.Game;
import logica.TileCreator;

public class Banshee extends Enemy{
	
	public static String type = "menor";

	public Banshee(Game game, TileCreator tc, float x, float y, int width, int height, int tileClass, int listPos) {
		super(type, game, tc, x, y, width, height, tileClass, listPos);
		this.hp = 3;
	}

	@Override
	public void tick() {
		movePattern();
		move();
	}

	@Override
	public void render(Graphics g) {
		if(hp==1) {
			g.drawImage(Assets.destBanshee, (int)x, (int)y, null);
		}else {
			g.drawImage(Assets.banshee, (int)x, (int)y, null);	
		}
	}
	
}
