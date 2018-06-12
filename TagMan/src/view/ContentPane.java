package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import controller.MainController;
import controller.TimeController;
import model.Game;

public class ContentPane extends JPanel {

	private JPanel sideBar;
	private TimeView timeView;
	private GameView gameView;
	private PlayView playView;
	
	public ContentPane(MainController mc, Game game) {
		this.setLayout(new GridBagLayout());
		
		timeView = new TimeView();
		gameView = new GameView(game);
		playView = new PlayView(game);
		
		
		createSideBar();
		addViews();
	}
	
	public PlayView getPlayView() {
		return playView;
	}
	
	public TimeView getTimeView() {
		return timeView;
	}
	
	private void addViews() {
		GridBagConstraints gbc = new GridBagConstraints();
	
		gbc.weightx = 0.2;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(sideBar, gbc);
		
		gbc.weightx = 1;
		gbc.gridy = 0;
		gbc.gridx = 1;
		this.add(playView, gbc);
	}
	
	private void createSideBar() {
		sideBar = new JPanel();
		sideBar.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.weightx = 1;
		gbc.weighty = 0.1;
		gbc.fill = GridBagConstraints.BOTH;
		sideBar.add(gameView, gbc);
		
		gbc.weighty = 0.9;
		gbc.gridy = 1;
		sideBar.add(timeView, gbc);
		
	}
	
}
