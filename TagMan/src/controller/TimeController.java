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
					mc.getGame().stopGame();
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		}
	}


	
}
