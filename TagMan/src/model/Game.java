package model;

import java.util.ArrayList;
import java.util.Observable;

import view.GameView;

public class Game extends Observable implements Runnable {

	private TagMan tagman;
	private Dash[] dashes;
	private Wall[] standardWalls;
	private int arenaWidth;
	private int arenaHeight;
	
	public Game() {
		configArenaSize();
		initializeObjects();
		resetDashPosition();
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				this.setChanged();
				this.notifyObservers();
				Thread.sleep(1000/30);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	private void resetDashPosition() {
		// Start dash position at the first free X with some spacing.
		int dashX = standardWalls[0].getWidth();
		
		int occupiedSpace = dashX * 4;
		int freeSpace = arenaWidth - occupiedSpace;
		
		int dashSpacing = freeSpace / 10;
		System.out.println(arenaWidth);
		
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
			dashes[d] = new Dash();
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
