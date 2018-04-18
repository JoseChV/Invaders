package entidades;

import interfaz.Game;
import logica.TileCreator;

public abstract class Enemy extends Ship{
	
	protected int tileClass;
	protected int listPos;
	protected TileCreator tc;
	
	protected float speed = 4.0f;
	protected double angle = 0;
	protected int radius = 10;
	protected boolean flag;
	
	protected int hp;
	public int cont= 0;
	public String type;
	
	
	
	public Enemy(String type, Game game, TileCreator tc, float x, float y, int width, int height, int tileClass, int listPos) {
		super(game, x, y, width, height);
		this.tileClass = tileClass;
		this.listPos = listPos;
		this.type = type;
		
	}
	public void movePattern() {
		angle += 0.1;
		if(tileClass == 5) {
			xMove = (int)(Math.cos(angle)*radius);
			yMove = (int)(Math.sin(angle)*radius);
			
		}else {
			if(flag) {
				xMove = speed; 
			}else {
				xMove = -speed;
			}
		}
		y += 0.5;
	}
	public boolean hit() {
		if(cont%50==0) {
			cont=0;
			this.setHp(hp-1);
			return true;
		}
		else {
			cont++;
			return false;
		}
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
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


