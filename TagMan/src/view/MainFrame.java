package view;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private ContentPane cp = new ContentPane();
	
	public MainFrame() {
		this.setTitle("TagMan by Tuan-Anh Nguyen");
		this.setContentPane(cp);
		this.pack();
	}
	
}
