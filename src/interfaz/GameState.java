package interfaz;

import java.awt.Graphics;

import entidades.Banshee;
import entidades.Enemy;
import entidades.Player;
import logica.Lista;
import logica.Nodo;
import logica.TileCreator;

public class GameState extends State{
	
	private Player player;
	private TileCreator tc = new TileCreator();
	private Lista<Enemy> lista;
	private BulletControl bc;
	
	public GameState(Game game) {
		super(game);
		this.bc = new BulletControl(game);
		player = new Player(game,750,490, 70, 154, bc);
		Lista<Enemy> lista = tc.newTile(game, 'A');
		
	}
	
	@Override
	public void tick() {
		player.tick();
		tc.tick();
	}

	@Override
	public void render(Graphics graphics) {
		player.render(graphics);
		tc.render(graphics);
		bc.update(graphics);
		
	}
}

