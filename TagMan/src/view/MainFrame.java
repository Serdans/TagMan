package view;

import javax.swing.JFrame;

import controller.MainController;
import model.Game;

public class MainFrame extends JFrame {

	private ContentPane cp;
	private MainController controller;
	
	public MainFrame(MainController controller, Game game) {
		cp = new ContentPane(game);
		
		this.controller = controller;
		this.setTitle("TagMan by Tuan-Anh Nguyen");
		this.setContentPane(cp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
	}
	
}
