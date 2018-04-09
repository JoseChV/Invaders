package interfaz;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static BufferedImage player, banshee, phantom, PA, destBanshee, destPhantom;
	public static int PAWidth = 29, PAHeight = 39, destBansheeWidth = 79, destBansheeHeight = 91, destPhantomWidth = 127, destPhantomHeight = 183;
	public static int playerWidth = 70, playerHeight = 154, bansheeWidth = 79, bansheeHeight = 91, phantomWidth = 127, phantomHeight = 183;
	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.load("/textures/Finished/sprites.png"));
		
		player = sheet.crop(105, 0, playerWidth, playerHeight);
		banshee = sheet.crop(0, 0, bansheeWidth, bansheeHeight);
		phantom = sheet.crop(192, 0, phantomWidth, phantomHeight);
		
		destBanshee = sheet.crop(215, 237, destBansheeWidth, destBansheeHeight);
		destPhantom = sheet.crop(9, 165, destPhantomWidth, destPhantomHeight);
		
		PA = sheet.crop(155,218, PAWidth, PAHeight);
		
		
	}
}
