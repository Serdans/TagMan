package controller;

import model.Game;
import view.MainFrame;

public class MainController {
	
	private MainFrame mainFrame;
	private Game game;
	private Thread thread;
	
	public MainController() {
		game = new Game();
		mainFrame = new MainFrame(this, game);
		
	}
	
	public void startApplication() {
		mainFrame.setVisible(true);
		
		thread = new Thread(game);
		thread.start();
	}
	
}
