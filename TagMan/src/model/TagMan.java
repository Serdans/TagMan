package model;

public class TagMan extends GameObject {

	private Game game;
	private int speed;
	
	public TagMan(Game game) {
		this.game = game;
		
		setX(25);
		setY(game.getArenaHeight()/2);
		
		setWidth(50);
		setHeight(50);
	}
	
	@Override
	public void moveObject(int x, int y) {
		System.out.println(getX() + " " + getY());
		super.moveObject(x, y);
	}
	
	
	private boolean collisionsUp() {
		boolean collisionsUp = true;
		if (getY() - getHeight() > 0) {
			collisionsUp = false;
		}
		return collisionsUp;
	}
	
	private boolean collisionsDown() {
		boolean collisionsDown = true;
		if (getY() - getHeight() < game.getArenaHeight()) {
			collisionsDown = false;
		}
		return collisionsDown;
	}
	
	private boolean collisionsLeft() {
		boolean collisionsLeft = true;
		if (getX() - getWidth() > 0) {
			collisionsLeft = false;
		}
		return collisionsLeft;
	}
	
	private boolean collisionsRight() {
		boolean collisionsRight = true;
		if (getX() + getWidth() < game.getArenaWidth()) {
			collisionsRight = false;
		}
		return collisionsRight;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getSpeed() {
		return speed;
	}
	
}
