package controller;

import java.util.Observable;

import view.TimeView;

public class TimeController extends Observable implements Runnable {

	private Thread thread;
	private int timer;
	private boolean countingDown;
	
	public TimeController(MainController mc) {
		this.addObserver(mc.getTimeView());
		timer = 30;
	}
	
	public void startTimer() {
		// Reset the timer and start counting down.
		timer = 30;
		countingDown = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public int getTime() {
		return timer;
	}

	@Override
	public void run() {
		while (countingDown) {
			try {
				this.setChanged();
				this.notifyObservers();
				timer --;
				Thread.sleep(1000);
				
				if (timer == 0) {
					// Update the value in the view.
					this.setChanged();
					this.notifyObservers();
					// Stop counting down.
					countingDown = false;
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		}
	}


	
}
