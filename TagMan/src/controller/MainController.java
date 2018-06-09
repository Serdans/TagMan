package controller;

import model.Game;
import view.MainFrame;

public class MainController {
	
	private MainFrame mainFrame;
	private Game game;
	
	public MainController() {
		game = new Game();
		mainFrame = new MainFrame(this);
		
	}
	
	public void startApplication() {
		mainFrame.setVisible(true);
	}
	
}
