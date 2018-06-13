package model;

public class TagMan extends GameObject {

	private Game game;
	private int speed;
	
	public TagMan(Game game) {
		this.game = game;
		
		setSpeed(5);
		
		setX(15);
		setY(game.getArenaHeight()/2);
		
		setWidth(30);
		setHeight(30);
	}
	
	@Override
	public void moveObject(int x, int y) {
		// Check if movement is being made along the x-axis or y-axis.
		int absX = Math.abs(x);
		int absY = Math.abs(y);
		
		if (absY > 0) {
			if (y > 0) {
				// Check if you are touching the bottom or the bottom edge.
				if (!touchingBottomEdge()) {
					super.moveObject(x, y);
				}
			} else {
				if (!touchingTopEdge()) {
					if (!aboutToHitWall()) {
						super.moveObject(x, y);
					}
				}
			}
		}
		
		else {
			super.moveObject(x, y);
		}
		
		System.out.println(getX() + " " + getY());
	}
	
	private boolean aboutToHitWall() {
		boolean hit = true;
		
		Wall[] walls = game.getStandardWalls();
		
		
		int xWallMax = walls[0].getX() + walls[0].getWidth();
		int xTagMax = this.getX() + this.getWidth() / 2;
		
		int xWallMin = walls[0].getX();
		int xTagMin = this.getX() - this.getWidth() / 2;
		
		if (xTagMin >= xWallMax || xTagMax <= xWallMin) {
			hit = false;
		}
		return hit;
	}
	
	private boolean horizontalCollision() {
		boolean hit = true;
		
		Wall[] walls = game.getStandardWalls();
		
		int yWallMax = walls[0].getY() + walls[0].getHeight();
		int yTagMax = this.getY() + this.getHeight() / 2;
		
		int yWallMin = walls[0].getY();
		int yTagMin = this.getY() - this.getHeight() / 2;
		
		if (yTagMin >= yWallMax || yTagMax >= yWallMin) {
			hit = false;
		}
		
		return hit;
	}
	
	private boolean touchingBottomEdge() {
		boolean touching = false;
		int tagManBottom = getHeight() / 2 + getY();
		if (tagManBottom >= game.getArenaHeight()) {
			touching = true;
		}
		return touching;
	}
	
	private boolean touchingTopEdge() {
		boolean touching = false;
		int tagManTop = getY() - getHeight() / 2;
		if (tagManTop <= 0) {
			touching = true;
		}
		return touching;
	}
	
	private boolean collisionsUp() {
		boolean collisionsUp = true;
		Wall[] standardWalls = game.getStandardWalls();
		int upperEdgeY = getY() - getHeight() / 2;
		
		for (Wall wall : standardWalls) {
			if (upperEdgeY < (wall.getY() + wall.getHeight())) {
				collisionsUp = false;
			}
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
		boolean collisionsLeft = false;
		
		int x1 = getX();
		int y1 = getY();
		int y2 = getY() + getHeight();
		
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
