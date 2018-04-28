package interfaz;

import java.awt.Color;
import java.awt.Graphics;

import entidades.Bullet;
import entidades.Enemy;
import entidades.Player;
import logica.Nodo;
import logica.TileCreator;
/**
 * Estado principal del juego.
 * @author Jose Andres Ch
 *
 */
public class GameState extends State{
	
	private Player player;
	private TileCreator tc;
	private BulletControl bc;
	public int score = 0;
	private int cont = 0;
	
	/**
	 * Inicio del juego.
	 * @param game aplicacion principal
	 */
	public GameState(Game game) {
		super(game);
		this.tc = new TileCreator(game,this);
		this.bc = new BulletControl(game);
		player = new Player(game,650,490, 70, 154, bc);
		tc.newTile(game);
		
	}
	/**
	 * Revisa que las balas choquen con las naves enemigas.
	 */
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
				Nodo<Enemy> temp = tc.list.getPrimero();
				if(temp!= null) {
					while(temp.getSiguiente() != tc.list.getPrimero()) {
						if(b.getValor().getX()>temp.getValor().getX() && b.getValor().getWidth()<temp.getValor().getWidth() && b.getValor().getY()<temp.getValor().getHeight() && !(b.getValor().getHeight()<temp.getValor().getY())) {
							if(temp.getValor().hit()) {
								bc.removeBullet(b.getValor());
								if(temp.getValor().getHp()==0) {
									tc.remove(temp.getValor());
								}
							}
						}
						temp = temp.getSiguiente();
					}
				}
				if(temp!= null) {
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
	
	/**
	 *Revisa si las naves enemigas chocan con la nave del jugador. 
	 */
	private void checkShipCollision() {
		if(tc.typeClass <=2) {
			for(Nodo<Enemy> e = tc.list.getPrimero(); e != null; e = e.getSiguiente()) {
				if(player.getX()>e.getValor().getX() && player.getWidth()<e.getValor().getWidth() && player.getY()<e.getValor().getHeight() && !(player.getHeight()<e.getValor().getY())) {
					tc.remove(e.getValor());
					player.setHp(player.getHp()-1);
				}
			}
		}else {
			Nodo<Enemy> e = tc.list.getPrimero();
			if(e != null) {
				while(e.getSiguiente() != tc.list.getPrimero()) {
					if(player.getX()>e.getValor().getX() && player.getWidth()<e.getValor().getWidth() && player.getY()<e.getValor().getHeight() && !(player.getHeight()<e.getValor().getY())) {
						tc.remove(e.getValor());
						player.setHp(player.getHp()-1);
					}
					e = e.getSiguiente();
				}
				if(e != null) {
					if(player.getX()>e.getValor().getX() && player.getWidth()<e.getValor().getWidth() && player.getY()<e.getValor().getHeight() && !(player.getHeight()<e.getValor().getY())) {
						tc.remove(e.getValor());
						player.setHp(player.getHp()-1);
					}
				}
			}
		}
	}
	
	/**
	 * Revisa los estados de las naves en pantalla.
	 */
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
		if(tc.typeClass<=2) {
			for(Nodo<Enemy> e = tc.list.getPrimero(); e != null; e=e.getSiguiente()) {
				if(e.getValor().getX()<-20 || e.getValor().getX()>1400) {
					tc.remove(e.getValor());
				}
			}
		}else {
			Nodo<Enemy> e = tc.list.getPrimero();
			if(e!=null) {
				while(e.getSiguiente() != tc.list.getPrimero()) {
					if(e.getValor().getX()<-20 || e.getValor().getX()>1400) {
						tc.remove(e.getValor());
					}
					e = e.getSiguiente();
				}
				if(e != null) {
					if(e.getValor().getX()<-20 || e.getValor().getX()>1400) {
						tc.remove(e.getValor());
					}
				}
			}
		}
	}
	/**
	 * Actualiza todas las variables en el juego.
	 */
	@Override
	public void tick() {
		checkShipConditions();
		checkShipCollision();
		checkBulletCollision();
		player.tick();
		tc.tick();
		if(game.getMouseManager().rightPressed) {
			if(this.cont%30==0) {
				tc.newTile(game);
				this.cont = 0;
			}
		}
		this.cont ++;
		
	}
	/**
	 * Renderiza todos los objetos del juego.
	 */
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.bg, 0, 0, null);
		player.render(g);
		tc.render(g);
		bc.update(g);
		
		Text.drawString(g, "Score: "+ Integer.toString(score), 900, 40, Color.WHITE, Assets.font28);
		Text.drawString(g, "Tile: " + tc.getTypeClassString(), 100, 40, Color.WHITE, Assets.font28);
		Text.drawString(g, "Lives: " + Integer.toString(player.getHp()), 1000, 620, Color.WHITE, Assets.font28);
		
		
	}
}

