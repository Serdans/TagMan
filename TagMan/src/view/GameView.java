package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Game;

public class GameView extends JPanel implements Observer {

	private Game game;

	private JLabel scoreText;
	private JLabel scoreAmount;
	
	private JLabel levelText;
	private JLabel levelNumber;
	
	private Font amountFont;
	
	
	public GameView(Game game) {
		this.game = game;
		game.addObserver(this);
		
		this.setBackground(Color.BLACK);
		this.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GRAY));
		
		initializeComponents();
		addComponents();
	}

	private void initializeComponents() {
		scoreText = new JLabel("Score");
		scoreAmount = new JLabel("0");
		
		levelText = new JLabel("Level");
		levelNumber = new JLabel("0");
		
		amountFont = new Font("Calibri", Font.BOLD, 40);
		scoreAmount.setFont(amountFont);
		levelNumber.setFont(amountFont);
		
		scoreText.setHorizontalAlignment(JLabel.CENTER);
		scoreAmount.setHorizontalAlignment(JLabel.CENTER);
		levelText.setHorizontalAlignment(JLabel.CENTER);
		levelNumber.setHorizontalAlignment(JLabel.CENTER);
		
		scoreText.setBackground(Color.GRAY);
		scoreAmount.setBackground(Color.GRAY);
		levelText.setBackground(Color.GRAY);
		levelNumber.setBackground(Color.GRAY);
		
		scoreText.setOpaque(true);
		scoreAmount.setOpaque(true);
		levelText.setOpaque(true);
		levelNumber.setOpaque(true);
		
		scoreText.setForeground(Color.YELLOW);
		scoreAmount.setForeground(Color.YELLOW);
		levelText.setForeground(Color.YELLOW);
		levelNumber.setForeground(Color.YELLOW);
	}
	
	private void addComponents() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(20, 20, 0, 20);
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(scoreText, gbc);
		
		gbc.gridy = 1;
		this.add(scoreAmount, gbc);
		
		gbc.insets = new Insets(40, 20, 0, 20);
		gbc.gridy = 2;
		this.add(levelText, gbc);
		
		gbc.insets = new Insets(20, 20, 20, 20);
		gbc.gridy = 3;
		this.add(levelNumber, gbc);
	}
	
	private void setLevel(int level) {
		String levelString = Integer.toString(level);
		levelNumber.setText(levelString);
	}
	
	private void setScore(int score) {
		String scoreString = Integer.toString(score);
		scoreAmount.setText(scoreString);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		setLevel(game.getLevel());
		setScore(game.getScore());
	}
	
	
	
}
