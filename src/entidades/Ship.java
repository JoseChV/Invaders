package entidades;

import interfaz.Game;

public abstract class Ship extends Entity{
	
	protected int hp;
	protected float speed;
	
	
	
	
	public Ship(Game game, float x, float y, int width, int height) {
		super(game, x, y, width, height);
		speed = 4.0f;
		hp = 3;
		
	
	}
	

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	


}
