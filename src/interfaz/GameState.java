package interfaz;

import java.awt.Graphics;

import entidades.Bullet;
import entidades.Enemy;
import entidades.Player;
import logica.Nodo;
import logica.TileCreator;

public class GameState extends State{
	
	private Player player;
	private TileCreator tc;
	private BulletControl bc;
	
	public GameState(Game game) {
		super(game);
		this.tc = new TileCreator(game);
		this.bc = new BulletControl(game);
		player = new Player(game,750,490, 70, 154, bc);
		tc.newTile(game);
		
	}
	public void checkCollision() {
		if (tc.typeClass<=2) {
			for(Nodo<Enemy> e = tc.list.getPrimero();e != null;e = e.getSiguiente() ) {
				for(Nodo<Bullet> b = bc.lista.getPrimero(); b != null; b = b.getSiguiente()) {
					if(b.getValor().getX()>e.getValor().getX() && b.getValor().getWidth()<e.getValor().getWidth() && b.getValor().getY()<e.getValor().getHeight() && !(b.getValor().getHeight()<e.getValor().getY())) {
						if(e.getValor().hit()) {
							bc.removeBullet(b.getValor());
							if(e.getValor().getHp()==0) {
								tc.remove(e.getValor());
							}
						}
					}
				}
			}
		}else {
			Nodo<Enemy> temp = tc.list.getPrimero();
			while(temp.getSiguiente() != tc.list.getPrimero()) {
				for(Nodo<Bullet> b = bc.lista.getPrimero(); b != null; b = b.getSiguiente()) {
					if(b.getValor().getX()>temp.getValor().getX() && b.getValor().getWidth()<temp.getValor().getWidth() && b.getValor().getY()<temp.getValor().getHeight() && !(b.getValor().getHeight()<temp.getValor().getY())) {
						if(temp.getValor().hit()) {
							bc.removeBullet(b.getValor());
							if(temp.getValor().getHp()==0) {
								tc.remove(temp.getValor());
							}
						}
					}
				}
				temp = temp.getSiguiente();
			}
		}
	}
	
	@Override
	public void tick() {
		player.tick();
		tc.tick();
		checkCollision();
	}

	@Override
	public void render(Graphics g) {
		player.render(g);
		tc.render(g);
		bc.update(g);
		
	}
}

