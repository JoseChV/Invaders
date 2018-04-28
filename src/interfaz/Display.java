package interfaz;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * Display
 * @author Jose Andres Ch
 *
 */
public class Display {
	private JFrame frame;
	private Canvas canvas;
	/**
	 * Inicializa el Display del juego
	 */
	public Display() {
		createDisplay();
	}
	/**
	 * Crea el display
	 */
	private void createDisplay() { 
		frame = new JFrame("Invaders");
		frame.setSize(1300, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(1300,650));
		canvas.setMinimumSize(new Dimension(1300,650));
		canvas.setMaximumSize(new Dimension(1300,650));
		
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
	}
	/**
	 * Retorna el Canvas
	 * @return Canvas
	 */
	public Canvas getCanvas() {
		return this.canvas;
	}
	
	/**
	 * Retorna el JFrame
	 * @return JFrame
	 */
	public JFrame getFrame() {
		return frame;
	}

}
