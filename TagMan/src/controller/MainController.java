package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

import model.Game;
import view.MainFrame;
import view.TimeView;

public class MainController {
	
	private MainFrame mainFrame;
	private TimeController tc;
	private Game game;
	private Thread thread;

	
	public MainController() {
		game = new Game();		
		mainFrame = new MainFrame(this, game);

		tc = new TimeController(this);
		mainFrame.getTimeView().setTimeController(tc);

		addMovementBindings();
		tc.startTimer();
	}
	
	public void startApplication() {
		mainFrame.setVisible(true);
		
		thread = new Thread(game);
		thread.start();
	}
	
	public Game getGame() {
		return game;
	}
	
	public TimeView getTimeView() {
		return mainFrame.getTimeView();
	}
	
	public TimeController getTimeController() {
		return tc;
	}
	
	private void addMovementBindings() {
		InputMap im = mainFrame.getPlayViewInputMap();
		ActionMap am = mainFrame.getPlayViewActionMap();
		
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "UP");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "LEFT");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "RIGHT");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "DOWN");
		
		am.put("UP", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int speed = game.getTagMan().getSpeed();
				game.getTagMan().moveObject(0, -speed);
			}
		});
		
		am.put("LEFT", new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int speed = game.getTagMan().getSpeed();
				game.getTagMan().moveObject(-speed, 0);
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
