package entidades;

import java.awt.Graphics;

import interfaz.Game;

public abstract class Entity {
	
	protected float x, y;
	protected int width, height;
	protected Game game;
	
	protected float xMove, yMove;
	
	public Entity(Game game, float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.game = game;
		xMove = 0; 
		yMove = 0;
		
	}
	public void move() {
		x += xMove; 
		y += yMove;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics graphics);
	
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	
}
	
