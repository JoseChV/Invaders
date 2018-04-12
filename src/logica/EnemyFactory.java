package logica;

import entidades.Banshee;
import entidades.Enemy;
import entidades.Phantom;
import interfaz.Game;

public class EnemyFactory extends TileCreator{
	private Game game;
	public EnemyFactory (Game game) {
		this.game = game;
	}
	public Enemy newEnemy(String type, int x, int y, char typeClass, int listPos) {
		if(type == "menor") {
			return new Banshee(game, x, y, 79, 91, typeClass, listPos);
			
		}else if(type == "boss") {
			return new Phantom(game, x, y, 127, 183, typeClass, listPos);
		
		}else {
			System.out.println("null");
			return null;
		}
	}
}
