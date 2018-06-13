package controller;

import java.util.Observable;

import view.TimeView;

public class TimeController extends Observable implements Runnable {

	private MainController mc;
	private Thread thread;
	private int timer;
	private boolean countingDown;
	
	public TimeController(MainController mc) {
		this.mc = mc;
		this.addObserver(mc.getTimeView());
		timer = 30;
		
		// Indicate that the controller has initialized its time.
		setChanged();
	}
	
	public void startTimer() {
		// Reset the timer and start counting down.
		timer = 30;
		countingDown = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void stopTimer() {
		this.countingDown = false;
	}
	
	public int getTime() {
		return timer;
	}

	@Override
	public void run() {
		while (countingDown) {
			try {
				timer --;
				this.setChanged();
				this.notifyObservers();
				
				Thread.sleep(1000);
				
				// Timer stops if level is no longer in progress, or the timer reaches 0.
				if (!mc.getGame().levelInprogress() && !mc.getGame().getTagMan().getDead()) {
					// Set score if level is no longer in progress and TagMan didn't die.
					int currentScore = mc.getGame().getScore();
					int newScore = currentScore + timer;
					mc.getGame().setScore(newScore);
					countingDown = false;
					this.setChanged();
					this.notifyObservers();
				} else if (timer == 0) {
					// Update the value in the view.
					this.setChanged();
					this.notifyObservers();
					// Stop counting down.
					countingDown = false;
					mc.getGame().stopGame();
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		}
	}


	
}
