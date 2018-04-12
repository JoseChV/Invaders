package interfaz;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

//import logica.EnemyFactory;

public class Game implements Runnable{
	
	private Display display;
	private Thread thread; 
	private boolean running = false;
	private BufferStrategy buffer;
	private Graphics graphics;
	private KeyManager keyManager;
	
	//private EnemyFactory factory;
	
	private State gameState;
	private State menuState;
	
	public Game() {
		keyManager = new KeyManager();
		 
	}
	
	private void init() {
		display = new Display();
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		gameState = new GameState(this);
		menuState = new MenuState(this);
		State.setState(gameState);
		
		
	}
	
	
	private void tick() {
		keyManager.tick();
		
		if(State.getState() != null) {
			State.getState().tick();
		}
		
	}
	
	private void render() {
		buffer = display.getCanvas().getBufferStrategy();
		if(buffer == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		graphics = buffer.getDrawGraphics();
		graphics.clearRect(0, 0, 1300, 650);
		
		graphics.drawImage(Assets.bg, 0, 0, null);
		
		if(State.getState() != null) {
			State.getState().render(graphics);
		}
		
		buffer.show();
		graphics.dispose();
	}
	
	public void run() {

		init();	
		
		//Control del fps
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now = 0;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		//Loop principal del juego
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) /  timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1) {
				tick();
				render();
				ticks++;
				delta --;
			}
			if(timer>=1000000000) {
				ticks = 0;
				timer = 0;
			}
		}
		stop();
	}
	public KeyManager getKeyManager() {
		return keyManager;
	}
	//Comienza el programa
	public synchronized void start() {
		if(running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	//Para el programa
	

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
