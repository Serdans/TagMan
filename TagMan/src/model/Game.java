package model;

import java.util.Observable;

import view.GameView;

public class Game extends Observable {

	private GameView gameView;
	private TagMan tagman;
	private Dash[] dashes;
	
	public Game() {
		this.addObserver(gameView);
		initializeObjects();
	}
	
	private void initializeObjects() {
		tagman = new TagMan();
		
		for (int d = 0; d < 10; d++) {
			dashes[d] = new Dash();
		}
	}
	
	public TagMan getTagMan() {
		return tagman;
	}
	
}
