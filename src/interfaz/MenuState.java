package interfaz;

import java.awt.Color;
import java.awt.Graphics;
/**
 * Estado del menu
 * @author Jose Andres Ch
 *
 */
public class MenuState extends State {
	/**
	 * Inicializa el menu
	 * @param game Juego
	 */
	public MenuState(Game game) {
		super(game);
	}
	/**
	 * Actualiza variables
	 */
	@Override
	public void tick() {
		if(game.getMouseManager().leftPressed) {
			State.setState(new GameState(game));
		}
	}
	/**
	 * Renderiza imagenes
	 */
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.bg, 0, 0, null);
		
		Text.drawString(g, "INVADERS", 250, 250, Color.WHITE, Assets.menuFont);
		Text.drawString(g, "Play", 600, 500, Color.WHITE, Assets.font28);
	}

}
