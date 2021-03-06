package interfaz;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Maneja el estado del mouse
 * @author Jose Andres Ch
 *
 */
public class MouseManager implements MouseListener, MouseMotionListener{
	public boolean leftPressed, rightPressed;
	public int mouseX, mouseY;
	
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			leftPressed = true;
		}else if(e.getButton() == MouseEvent.BUTTON3) {
			 rightPressed = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			leftPressed = false;
		}else if(e.getButton() == MouseEvent.BUTTON3) {
			 rightPressed = false;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
