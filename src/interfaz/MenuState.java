package interfaz;

import java.awt.Graphics;

public class MenuState extends State {

	public MenuState(Game game) {
		super(game);
	}

	@Override
	public void tick() {
		if(game.getMouseManager().rightPressed) {
			State.setState(new GameState(game));
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.bg, 0, 0, null);
	}

}
