package interfaz;

import java.awt.image.BufferedImage;
/**
 * Sprite Sheet
 * @author Jose Andres Ch
 *
 */
public class SpriteSheet {
	
	private BufferedImage sheet;
	
	/**
	 * Inicializa el Sprite Sheet
	 * @param sheet Imagen de sprites
	 */
	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}
	
	/**
	 * Corta la porcion del Sprite Sheet deseada
	 * @param x Posicion en x
	 * @param y Posicion en y
	 * @param width Grosor
	 * @param height Altura
	 * @return Imagen cortada
	 */
	public BufferedImage crop(int x, int y, int width, int height){
		return sheet.getSubimage(x, y, width, height);
		
	}
}
