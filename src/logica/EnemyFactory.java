package logica;

import entidades.Banshee;
import entidades.Enemy;
import entidades.Phantom;
import interfaz.Game;
/**
 * Factory para crear enemigos.
 * @author Jose Andres Ch
 *
 */
public class EnemyFactory{
	private Game game;
	private TileCreator tc;
	public Enemy boss;
	public EnemyFactory (Game game, TileCreator tc) {
		this.game = game;
		this.tc = tc;
	}
	/**
	 * Crea un nuevo enemigo basado en el parametro type.
	 * @param type tipo de enemigo a crear.
	 * @param x posicion del enemigo en el eje x.
	 * @param y posicion del enemigo en el eje y.
	 * @param radius distancia del enemigo al enemigo jefe.
	 * @param angle angulo del circulo para determinar su nueva posicion.
	 * @return nuevo Enemigo.
	 */
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
