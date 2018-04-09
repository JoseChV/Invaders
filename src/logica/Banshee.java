package logica;

import interfaz.Assets;

public class Banshee extends Enemy {
	public Banshee(int xpos,int ypos) {
		this.sprite = Assets.banshee;
		this.height = Assets.bansheeHeight;
		this.width = Assets.bansheeWidth;
		this.hp = 3;
		this.xPos = xpos;
		this.xPos = ypos;
	}
	public void setHp(int hp) {
		this.hp = hp;
		if(hp==0) {
			this.destroy();
		}
	}
	public void destroy() {
		this.sprite = Assets.destBanshee;
	}
	
}
