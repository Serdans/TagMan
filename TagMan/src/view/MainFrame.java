package view;

import javax.swing.JFrame;

import controller.MainController;

public class MainFrame extends JFrame {

	private ContentPane cp = new ContentPane();
	private MainController controller;
	
	public MainFrame(MainController controller) {
		this.controller = controller;
		this.setTitle("TagMan by Tuan-Anh Nguyen");
		this.setContentPane(cp);
		this.pack();
	}
	
}
