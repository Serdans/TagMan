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
	
	
	private void initializeObjects() {
		tagman = new TagMan(this);
		tagman.setSpeed(10);
		
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
		
		standardWalls[1].setY(300);
		
		standardWalls[2].setX(500);
		
		standardWalls[3].setX(500);
		standardWalls[3].setY(300);
	}


	
}
