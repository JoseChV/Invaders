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
		player = new Player(game,650,490, 70, 154, bc);
		tc.newTile(game);
		
	}
	public void checkBulletCollision() {
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
			for(Nodo<Bullet> b = bc.lista.getPrimero(); b != null; b = b.getSiguiente()) {
				Nodo<Enemy> temp = null;
				for(Nodo<Enemy> e = tc.list.getPrimero(); e.getSiguiente()!= tc.list.getPrimero(); e = e.getSiguiente()) {
					temp = e;
					if(b.getValor().getX()>e.getValor().getX() && b.getValor().getWidth()<e.getValor().getWidth() && b.getValor().getY()<e.getValor().getHeight() && !(b.getValor().getHeight()<e.getValor().getY())) {
						if(e.getValor().hit()) {
							bc.removeBullet(b.getValor());
							if(e.getValor().getHp()==0) {
								tc.remove(e.getValor());
							}
						}
					}
				}if(temp!= null) {
					if(b.getValor().getX()>temp.getValor().getX() && b.getValor().getWidth()<temp.getValor().getWidth() && b.getValor().getY()<temp.getValor().getHeight() && !(b.getValor().getHeight()<temp.getValor().getY())) {
						if(temp.getValor().hit()) {
							bc.removeBullet(b.getValor());
							if(temp.getValor().getHp()==0) {
								tc.remove(temp.getValor());
							}
						}
					}

				}
			}
		}
	}
	private void checkShipCollision() {
		if(tc.typeClass <=2) {
			for(Nodo<Enemy> e = tc.list.getPrimero(); e != null; e = e.getSiguiente()) {
				if(player.getX()>e.getValor().getX() && player.getWidth()<e.getValor().getWidth() && player.getY()<e.getValor().getHeight() && !(player.getHeight()<e.getValor().getY())) {
					tc.remove(e.getValor());
					player.setHp(player.getHp()-1);
				}
			}
		}
	}
	
	private void checkShipConditions() {
		if(tc.list.empty()) {
			tc.newTile(game);
			tc.destroyed = false;
		}else if(tc.list.getPrimero().getValor().getY()>650) {
			tc.newTile(game);
			tc.destroyed = false;
			player.setHp(player.getHp()-1);
		}
		if(player.getHp()<=0) {
			State.setState(game.menuState);
		}
	}
	
	@Override
	public void tick() {
		player.tick();
		checkBulletCollision();
		tc.tick();
		checkShipConditions();
		checkShipCollision();
		if(game.getMouseManager().rightPressed) {
			tc.newTile(game);
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.bg, 0, 0, null);
		player.render(g);
		tc.render(g);
		bc.update(g);
		
	}
}

