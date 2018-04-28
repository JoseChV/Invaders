package interfaz;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * Cargador de imagenes
 * @author Jose Andres Ch
 *
 */
public class ImageLoader {
	
	/**
	 * Carga la imagen
	 * @param path Direccion del archivo
	 * @return Imagen
	 */
	public static BufferedImage load(String path) {
		try {
			return ImageIO.read(ImageLoader.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
}
