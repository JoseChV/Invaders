package interfaz;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * Controlador del teclado
 * @author Jose Andres Ch
 *
 */
public class KeyManager implements KeyListener{
	
	private boolean[] keys;
	
	public boolean left, right, space;
	/**
	 * Inicializa el control
	 */
	public KeyManager() {
		keys = new boolean[256];
	}
	/**
	 * Actualiza variables
	 */
	public void tick() {
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		space = keys[KeyEvent.VK_SPACE];
	}
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	

}
