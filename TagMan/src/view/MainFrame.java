package view;

import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;

import controller.MainController;
import controller.TimeController;
import model.Game;

public class MainFrame extends JFrame {

	private ContentPane cp;
	
	public MainFrame(MainController controller, Game game) {
		cp = new ContentPane(controller, game);

		this.setTitle("TagMan by Tuan-Anh Nguyen");
		this.setContentPane(cp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
	}
	
	public TimeView getTimeView() {
		return cp.getTimeView();
	}
	
	public InputMap getPlayViewInputMap() {
		return cp.getPlayView().getInputMap();
	}
	
	public ActionMap getPlayViewActionMap() {
		return cp.getPlayView().getActionMap();
	}
	
}
