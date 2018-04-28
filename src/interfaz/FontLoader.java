package interfaz;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

/**
 * Carga la fuente de texto
 * @author Jose Andres Ch
 *
 */
public class FontLoader {
	
	/**
	 * Carga la fuente de texto
	 * @param path Direccion del archivo
	 * @param size Tamaño de letra
	 * @return Font
	 */
	public static Font loadFont(String path, int size) {
		try {
			return Font.createFont(Font.TRUETYPE_FONT, new File(path)).deriveFont(Font.PLAIN, size);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
}
