package interfaz;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static BufferedImage player, banshee, phantom, PA, destBanshee, destPhantom, bg;
	public static int PAWidth = 19, PAHeight = 34; 
	public static int playerWidth = 70, playerHeight = 154, bansheeWidth = 80, bansheeHeight = 94, phantomWidth = 127, phantomHeight = 183;
	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.load("/textures/Finished/sprites.png"));
		
		bg = ImageLoader.load("/textures/Finished/bg.jpg");
		
		player = sheet.crop(105, 0, playerWidth, playerHeight);
		banshee = sheet.crop(0, 0, bansheeWidth, bansheeHeight);
		phantom = sheet.crop(192, 0, phantomWidth, phantomHeight);
		
		destBanshee = sheet.crop(215, 237, bansheeWidth, bansheeHeight);
		destPhantom = sheet.crop(9, 165, phantomWidth, phantomHeight);
		
		PA = sheet.crop(163,224, PAWidth, PAHeight);
		
		
	}
}
