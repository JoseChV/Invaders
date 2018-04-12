package interfaz;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	private JFrame frame;
	private Canvas canvas;
	public Display() {
		createDisplay();
	}
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
	
	public Canvas getCanvas() {
		return this.canvas;
	}
	
	public JFrame getFrame() {
		return frame;
	}

}
