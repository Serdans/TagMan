package model;

import java.util.Observable;

import view.GameView;

public class Game extends Observable {

	private GameView gameView;
	private TagMan tagman;
	private Dash[] dashes;
	
	public Game() {
		this.addObserver(gameView);
	}
	
	
	
}
