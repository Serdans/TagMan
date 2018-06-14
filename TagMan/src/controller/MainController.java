package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

import model.Game;
import view.GameView;
import view.MainFrame;
import view.TimeView;

public class MainController {
	
	private MainFrame mainFrame;
	private TimeController tc;
	private SoundPlayer sp;
	private Game game;
	private Thread gameThread;
	
	
	public MainController() {
		sp = new SoundPlayer();
		game = new Game(this);		
		mainFrame = new MainFrame(this, game);
		tc = new TimeController(this);
		// Assign a TimeController to the Time View.
		mainFrame.getTimeView().setTimeController(tc);
		
		// Let Time View know that it has to update its timer.
		tc.notifyObservers();
		addMovementBindings();
	}
	
	public void startApplication() {
		mainFrame.setVisible(true);
		mainFrame.setLocationRelativeTo(null);
		
		gameThread = new Thread(game);
		gameThread.start();
	}
	
	public Game getGame() {
		return game;
	}
	
	public SoundPlayer getSoundPlayer() {
		return sp;
	}
	
	public TimeView getTimeView() {
		return mainFrame.getTimeView();
	}
	
	public GameView getGameView() {
		return mainFrame.getGameView();
	}
	
	public void stopTimer() {
		tc.stopTimer();
	}
	
	
	private void addMovementBindings() {
		InputMap im = mainFrame.getPlayViewInputMap();
		ActionMap am = mainFrame.getPlayViewActionMap();
		
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "UP");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "RIGHT");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "DOWN");
		
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD8, 0), "UP");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD6, 0), "RIGHT");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD2, 0), "DOWN");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD9, 0), "UP_RIGHT");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD3, 0), "DOWN_RIGHT");
		
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_L, 0), "NEXT");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "START");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "EXIT");
		
		am.put("NEXT", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (game.getTagMan().getFinished()) {
					if (game.advanceLevel()) {
						game.getTagMan().setFinished(false);
						mainFrame.getTimeView().setTimer(30);
						mainFrame.getPlayView().setBeginningLevelMessage();
					} else {
						mainFrame.getPlayView().setWonMessage();
					}
					
				}
				
			}
		});
		
		am.put("EXIT", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		am.put("START", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!game.levelInprogress() && !game.getTagMan().getFinished()) {
					game.startLevel();
					tc.startTimer();
				}
			}
		});
		
		am.put("UP_RIGHT", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int speed = game.getTagMan().getSpeed() * 2/3;
				game.getTagMan().moveObject(speed, -speed);
			}
		});
		
		am.put("DOWN_RIGHT", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int speed = game.getTagMan().getSpeed() * 2/3;
				game.getTagMan().moveObject(speed, speed);
			}
		});
		
		am.put("UP", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int speed = game.getTagMan().getSpeed();
				game.getTagMan().moveObject(0, -speed);
			}
		});
		
		am.put("RIGHT", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int speed = game.getTagMan().getSpeed();
				game.getTagMan().moveObject(speed, 0);
			}
		});
		
		am.put("DOWN", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int speed = game.getTagMan().getSpeed();
				game.getTagMan().moveObject(0, speed);
			}
		});
	}
	
}
