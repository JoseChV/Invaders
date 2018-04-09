package logica;

public class EnemyFactory {
	public Enemy newEnemy(String type, int xpos, int ypos) {
		if(type == "menor") {
			return new Banshee(xpos,ypos);
		}else if(type == "boss") {
			return new Boss();
		}else {
			return null;
		}
	}
}
