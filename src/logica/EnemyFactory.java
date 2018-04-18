package logica;

import entidades.Banshee;
import entidades.Enemy;
import entidades.Phantom;
import interfaz.Game;

public class EnemyFactory{
	private Game game;
	private TileCreator tc;
	public EnemyFactory (Game game, TileCreator tc) {
		this.game = game;
		this.tc = tc;
	}
	public Enemy newEnemy(String type, int x, int y) {
		if(type == "menor") {
			return new Banshee(game, tc, x, y, 79, 91, tc.typeClass, tc.cont);
			
		}else if(type == "boss") {
			return new Phantom(game, tc, x, y, 127, 183, tc.typeClass, tc.cont);
		
		}else {
			System.out.println("null");
			return null;
		}
	}
}
