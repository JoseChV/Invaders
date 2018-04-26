package logica;

import entidades.Banshee;
import entidades.Enemy;
import entidades.Phantom;
import interfaz.Game;

public class EnemyFactory{
	private Game game;
	private TileCreator tc;
	public Enemy boss;
	public EnemyFactory (Game game, TileCreator tc) {
		this.game = game;
		this.tc = tc;
	}
	public Enemy newEnemy(String type, int x, int y, float radius, double angle) {
		if(type == "menor") {
			return new Banshee(game, tc, x, y, 79, 91, tc.typeClass, radius, angle);
			
		}else if(type == "boss") {
			this.boss = new Phantom(game, tc, x, y, 127, 183, tc.typeClass, radius, angle);
			return boss;
		}else {
			System.out.println("null");
			return null;
		}
	}
}
