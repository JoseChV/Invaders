package entidades;

import interfaz.Game;

public abstract class Enemy extends Ship{
	
	protected char tileClass;
	protected int listPos;
	
	protected float speed = 4.0f;
	protected double angle = 0;
	protected int radius = 10;
	protected boolean flag;
	
	public Enemy(Game game, float x, float y, int width, int height, char tileClass, int listPos) {
		super(game, x, y, width, height);
		this.tileClass = tileClass;
		this.listPos = listPos;
	}
	public void movePattern() {
		angle += 0.1;
		if(tileClass == 'E') {
			xMove = (int)(Math.cos(angle)*radius);
			yMove = (int)(Math.sin(angle)*radius);
			
		}else {
			if(flag) {
				xMove = speed; 
			}else {
				xMove = -speed;
			}
			if(x<=200) {
				flag = true;
			}else if(x>=1000) {
				flag = false;
			}
		}
		y += 0.5;
	}
	
	
	@Override
	public int getHp() {
		return hp;
	}
	@Override
	public void setHp(int hp) {
		this.hp = hp;
	}

}
