package entidades;

import java.awt.Graphics;
import java.awt.Rectangle;

import interfaz.Game;

public abstract class Entity {
	
	protected float x, y;
	protected int width, height;
	protected Game game;
	public Rectangle bounds;
	
	protected float xMove, yMove;
	
	public Entity(Game game, float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.game = game;
		xMove = 0; 
		yMove = 0;
		
		this.bounds = new Rectangle(0,0,width,height);
		
	}
	public void move() {
		x += xMove; 
		y += yMove;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public float getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width + (int)x;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height + (int)y;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	
}
	
