package interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{
	
	private Display display;
	private Thread thread;
	private boolean running = false;
	private BufferStrategy buffer;
	private Graphics graphics;
	
	
	public Game() {
		
	}
	
	private void init() {
		display = new Display();
		Assets.init();
		
	}
	
	
	private void update() {
		
	}
	
	private void render() {
		buffer = display.getCanvas().getBufferStrategy();
		if(buffer == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		graphics = buffer.getDrawGraphics();
		graphics.clearRect(0, 0, 1300, 650);
		
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, 1300, 650);
		
		graphics.drawImage(Assets.player, 150, 50,null);
		graphics.drawImage(Assets.PA, 55, 200, null);
		graphics.drawImage(Assets.destBanshee, 250, 50,null);
		graphics.drawImage(Assets.banshee, 350, 50,null);
		graphics.drawImage(Assets.destPhantom, 570, 50,null);
		graphics.drawImage(Assets.banshee, 800, 50,null);
		graphics.drawImage(Assets.banshee, 900, 50,null);
		graphics.drawImage(Assets.banshee, 1000, 50,null);
		
		buffer.show();
		graphics.dispose();
	}
	
	public void run() {
		init();
		
		while(running) {
			update();
			render();
		}
		stop();
	}
	
	public synchronized void start() {
		if(running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running) {
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
