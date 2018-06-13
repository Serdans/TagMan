package model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

import controller.MainController;
import view.GameView;

public class Game extends Observable implements Runnable {

	private TagMan tagman;
	private Dash[] dashes;
	private Wall[] standardWalls;
	private int arenaWidth;
	private int arenaHeight;
	
	private boolean gameInProgress;
	private int currentLevel;
	private int score;
	
	private MainController mc;
	
	public Game(MainController mc) {
		this.mc = mc;
		
		configArenaSize();
		initializeObjects();
		resetDashPosition();
		gameInProgress = false;
	}
	
	public void startGame() {
		score = 0;
		currentLevel = 1;
		tagman.setFrozen(false);
		gameInProgress = true;
	}
	
	public void stopGame() {
		tagman.setFrozen(true);
	}
	
	public MainController getMainController() {
		return mc;
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				this.setChanged();
				this.notifyObservers();
				if (gameInProgress) {
					dropDashes();
				}
				Thread.sleep(1000/30);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean gameInProgress() {
		return gameInProgress;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getLevel() {
		return currentLevel;
	}
	
	public TagMan getTagMan() {
		return tagman;
	}
	
	public Wall[] getStandardWalls() {
		return standardWalls;
	}
	
	public Dash[] getDashes() {
		return dashes;
	}
	
	// Methods for arena
	public int getArenaWidth() {
		return arenaWidth;
	}
	
	public int getArenaHeight() {
		return arenaHeight;
	}
	
	private void configArenaSize() {
		arenaWidth = 1000;
		arenaHeight = 650;
	}
	
	private void dropDashes() {
		for (Dash dash : dashes) {
			if (!dash.getDropping()) {
				// This dash has not dropped yet. Deciding whether it's going to drop or not.
				Random random = new Random();
				int randomNumber = random.nextInt(4);
				if (randomNumber == 0) {
					// 20% chance of dropping.
					dash.setDropping(true);
					
					// Decide its falling speed.
					int fallSpeed = random.nextInt(4) + 2;
					dash.setFallSpeed(fallSpeed);
				}
			} else {
				dash.moveObject(0, dash.getFallSpeed());
			}
		}
	}
	
	private void resetDashPosition() {
		// Start dash position at the first free X with some spacing.
		int dashX = standardWalls[0].getWidth();
		
		// We can use the width of the wall to roughly calculate what space is occupied.
		int occupiedSpace = dashX * 4;
		int freeSpace = arenaWidth - occupiedSpace;
		
		// Place the dashes an even amount from each other.
		int dashSpacing = freeSpace / 10;
		
		dashX += dashSpacing;	
		
		for (Dash dash : dashes) {
			dash.setY(0);
			dash.setX(dashX);
			
			dashX += dashSpacing;
		}
	}

	
	private void initializeObjects() {
		tagman = new TagMan(this);
		
		dashes = new Dash[10];
		
		for (int d = 0; d < 10; d++) {
			dashes[d] = new Dash(this);
		}
		
		createStandardWalls();
	}

	private void createStandardWalls() {
		standardWalls = new Wall[4];
		
		for (int walls = 0; walls < 4; walls++) {
			standardWalls[walls] = new Wall();
		}
		
		for (Wall wall : standardWalls) {
			wall.createNormalWall();
		}
		
		int standardWallWidth = standardWalls[0].getWidth();
		int standardWallHeight = standardWalls[0].getHeight();
		
		
		
		standardWalls[1].setY(arenaHeight - standardWallHeight);
		standardWalls[2].setX(arenaWidth - standardWallWidth);
		
		
		standardWalls[3].setX(arenaWidth - standardWallWidth);
		standardWalls[3].setY(arenaHeight- standardWallHeight);
	}


	
}
