package model;

public class TagMan extends GameObject {

	private int speed;
	
	public TagMan() {
		setX(0);
		setY(0);
		
		setWidth(100);
		setHeight(100);
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getSpeed() {
		return speed;
	}
	
}
