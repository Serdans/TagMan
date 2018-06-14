package model;

import java.util.ArrayList;
import java.util.Arrays;

import controller.SoundPlayer;

public class TagMan extends GameObject {

	private Game game;
	private int speed;
	private AnimationFrame aniFrame;
	private boolean frozen;
	private boolean finished;
	private boolean dead;
	private SoundPlayer soundPlayer;
	
	public TagMan(Game game) {
		this.game = game;
		this.soundPlayer = game.getMainController().getSoundPlayer();
		
		// Initialize default values..
		frozen = true;
		finished = false;
		aniFrame = AnimationFrame.MOVE0; 
				
		setSpeed(15);
		
		setX(30);
		setY(game.getArenaHeight()/2);
		
		setWidth(30);
		setHeight(30);
	}
	
	public void setDead(boolean dead) {
		this.dead = dead;
		if (dead) {
			soundPlayer.playSound("dead");
			aniFrame = AnimationFrame.HIT;
			this.frozen = true;
		} else {
			this.frozen = false;
		}
	}
	
	public boolean getDead() {
		return dead;
	}
	
	public void setFrozen(boolean frozen) {
		this.frozen = frozen;
	}
	
	public void setFinished(boolean finished) {
		if (finished) {
			soundPlayer.playSound("finished");
			aniFrame = AnimationFrame.FINISHED;
		} else {
			aniFrame = AnimationFrame.MOVE1;
		}
		this.finished = finished;
	}
	
	public boolean getFinished() {
		return finished;
	}
	
	@Override
	public void moveObject(int x, int y) {
		boolean moved = false;
		
		if (!frozen) {
			// Check if movement is being made along the x-axis or y-axis.
			int absY = Math.abs(y);
			
			if (absY > 0) {
				if (y > 0) {
					// Check if you are touching the bottom or the bottom edge.
					if (!touchingBottomEdge()) {
						// Check if TagMan will collision with a wall.
						if (!moveWillCollision(x, y)) {
							super.moveObject(x, y);
							moved = true;
						}
					}
				} else {
					if (!touchingTopEdge()) {
						if (!moveWillCollision(x, y)) {
							super.moveObject(x, y); 
							moved = true;
						}
					}
				}
			}
			// Movement not along Y-axis. So it's along the X-axis.
			else {
				// Only have to check if TagMan collisions with a wall.
				if (!moveWillCollision(x, y)) {
					super.moveObject(x, y);
					moved = true;
				}
			}
			
			if (moved) {
				setMovementAnimation();
			}
		}
		
		// Calculate the x of TagMan's right edge.
		int tagManRightEdge = getX() + getWidth() / 2;
		
		// TagMan is finished if he finds himself within 10 pixels from the area end.
		if (tagManRightEdge >= game.getArenaWidth()-10) {
			this.setFinished(true);
			this.setFrozen(true);
		}	
	}
	
	public AnimationFrame getCurrentAnimationFrame() {
		return aniFrame;
	}
	
	private void setMovementAnimation() {
		switch (aniFrame) {
		case MOVE0:
			aniFrame = AnimationFrame.MOVE1;
			break;
		case MOVE1:
			aniFrame = AnimationFrame.MOVE2;
			break;
		case MOVE2:
			aniFrame = AnimationFrame.MOVE3;
			break;
		case MOVE3:
			aniFrame = AnimationFrame.MOVE4;
			break;
		case MOVE4:
			aniFrame = AnimationFrame.MOVE5;
			break;
		case MOVE5:
			aniFrame = AnimationFrame.MOVE0;
			break;
		default:
			
		}
	}
	
	// Collision method checks if you are bumping into any walls.
	private boolean moveWillCollision(int moveX, int moveY) {
		boolean collision = false;
		
		// Put standard walls and level walls in 1 list.
		ArrayList<Wall> allWalls = new ArrayList<Wall>();
		allWalls.addAll(Arrays.asList(game.getStandardWalls()));
		allWalls.addAll(game.getLevelWalls());
		
		int newPosX = this.getX() + moveX;
		int newPosY = this.getY() + moveY;

		// Check for all walls if TagMan will collision with them.
		for (Wall wall : allWalls) {
			int xWallMax = wall.getX() + wall.getWidth();
			int xTagMax = newPosX + this.getWidth() / 2;
			
			int xWallMin = wall.getX();
			int xTagMin = newPosX - this.getWidth() / 2;
			
			int yWallMax = wall.getY() + wall.getHeight();
			int yTagMax = newPosY + this.getHeight() / 2;
			
			int yWallMin = wall.getY();
			int yTagMin = newPosY - this.getHeight() / 2;
			
			// Conditions for collision are:
			// 1: TagMan x1 < x2 of object
			// 2: TagMan x2 > x1 of object
			// 3: TagMan y1 < y2 of object
			// 4: TagMan y2 > y1 of object
			if (xTagMin < xWallMax && xTagMax > xWallMin && yTagMin < yWallMax && yTagMax > yWallMin) {
				collision = true;
				// Allow baby steps to move up against the wall.
				moveObject(moveX/2, moveY/2);
				break;
			}
		}
		return collision;
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
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getSpeed() {
		return speed;
	}
	
}
