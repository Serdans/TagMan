package model;

import java.util.Observable;

import view.GameView;

public class Game extends Observable implements Runnable {

	private TagMan tagman;
	private Dash[] dashes;
	
	public Game() {
		
		initializeObjects();
	}
	
	public TagMan getTagMan() {
		return tagman;
	}
	
	private void initializeObjects() {
		tagman = new TagMan();
		tagman.setSpeed(10);
		
		dashes = new Dash[10];
		
		for (int d = 0; d < 10; d++) {
			dashes[d] = new Dash();
		}
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


	
}
