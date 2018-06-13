package view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Stroke;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Game;

public class Message extends JPanel {

	private Game game;
	private JLabel message;
	private Font messageFont;
	
	public Message(Game game) {
		this.setPreferredSize(new Dimension(500, 300));
		this.game = game;
		addMessage();
		this.setOpaque(false);
	}
	
	public void setWelcomeMessage() {
		message.setText("<html><center>Welcome to TagMan<br>move with arrows or numpad<br><br>Level 1<br>Hit S to start!</html>");
	}
	
	public void setPreLevelStartMessage() {
		message.setText("<html><center>Level " + game.getCurrentLevel() + " <br>Hit S to start!</html>");
	}
	
	public void setGameOverMessage() {
		message.setText("<html><center>HIT - Game Over!<br>Your score: " + game.getScore() + "<br>Press ESC to Exit.</html>");
	}
	
	public void setLevelOverMessage() {
		message.setText("<html><center>Level Complete<br>Current Score: " + game.getScore() + "<br><br>Hit L to continue.</html>");
	}
	
	public void setWonMessage() {
		message.setText("<html><center>Congratulations!<br>You've won with a score of: " + game.getScore() + " </html>");
	}
	
	private void addMessage() {
		message = new JLabel("<html><center>Welcome to TagMan<br>move with arrows or numpad<br><br>LEVEL ASS<br>Hit S to start!</html>");
		
		messageFont = new Font("Calibri", Font.BOLD, 30);
		
		
		message.setFont(messageFont);
		message.setForeground(Color.YELLOW);
		message.setHorizontalAlignment(JLabel.HORIZONTAL);
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.insets = new Insets(20, 20, 20, 20);
		this.add(message, gbc);
	}

	
}
