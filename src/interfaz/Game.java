package interfaz;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 * Juego Principal
 * @author Jose Andres Ch
 *
 */
public class Game implements Runnable{
	
	private Display display;
	private Thread thread; 
	private boolean running = false;
	private BufferStrategy buffer;
	private Graphics g;
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	
	public State gameState;
	public State menuState;
	
	/**
	 * Crea el juego
	 */
	public Game() {
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
		 
	}
	/**
	 * Inicializa el display, los controladores y carga los archivos necesarios.
	 */
	private void init() {
		display = new Display();
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();
		
		gameState = new GameState(this);
		menuState = new MenuState(this);
		State.setState(menuState);
		
		
	}
	
	/**
	 * Actualiza todas las variables del juego
	 */
	private void tick() {
		keyManager.tick();
		
		if(State.getState() != null) {
			State.getState().tick();
		}
		
	}
	/**
	 * Renderiza todos los objetos.
	 */
	private void render() {
		buffer = display.getCanvas().getBufferStrategy();
		if(buffer == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = buffer.getDrawGraphics();
		g.clearRect(0, 0, 1300, 650);
		
		
		
		if(State.getState() != null) {
			State.getState().render(g);
		}
		
		buffer.show();
		g.dispose();
	}
	/**
	 * Corre el juego
	 */
	public void run() {

		init();	
		
		//Control del fps
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now = 0;
		long lastTime = System.nanoTime();
		long timer = 0;
		
		//Loop principal del juego
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) /  timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1) {
				tick();
				render();
				delta --;
			}
			if(timer>=1000000000) {
				timer = 0;
			}
		}
		stop();
	}
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public MouseManager getMouseManager() {
		return mouseManager;
	}
	/**
	 * Comienza el programa
	 */
	public synchronized void start() {
		if(running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	/**
	 * Detiene el programa
	 */
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
