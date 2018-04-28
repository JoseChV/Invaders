package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
/**
 * Escribe el texto
 * @author Jose Andres Ch
 *
 */
public class Text {
	/**
	 * Digubja el texto en pantalla
	 * @param g Componente grafico
	 * @param text Texto
	 * @param xPos Posicion en x
	 * @param yPos Posicion en y
	 * @param color Color del texto
	 * @param font Texto fuente
	 */
	public static void drawString(Graphics g, String text, int xPos, int yPos, Color color, Font font) {
		g.setColor(color);
		g.setFont(font);
		int y = yPos;
		int x = xPos;
		
		g.drawString(text, x, y);
	}
}
