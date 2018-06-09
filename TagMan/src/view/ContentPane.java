package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class ContentPane extends JPanel {

	private TimeView timeView;
	private GameView gameView;
	private PlayView playView;
	
	public ContentPane() {
		this.setPreferredSize(new Dimension(1300, 800));
		this.setLayout(new GridBagLayout());
		
		timeView = new TimeView();
		gameView = new GameView();
		playView = new PlayView();
		
		addViews();
	}
	
	private void addViews() {
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.weightx = 0.2;
		gbc.weighty = 0.2;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(gameView, gbc);
		
		gbc.gridy = 1;
		this.add(timeView, gbc);
		
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridy = 0;
		gbc.gridx = 1;
		this.add(playView, gbc);
	}
	
}
