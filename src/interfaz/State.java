package interfaz;

import java.awt.Graphics;

/**
 * Estado actual del juego
 * @author Jose Andres Ch
 *
 */
public abstract class State {
	
	
	private static State currentState = null;
	
	protected Game game;
	/**
	 * Inicializa un nuevo estado
	 * @param game Juego
	 */
	public State(Game game) {
		this.game = game;
	}
	
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics graphics);


}
