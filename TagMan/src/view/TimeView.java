package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class TimeView extends JPanel {

	private Font timeFont;
	private JLabel timeAmount;
	private JProgressBar timerBar;
	
	public TimeView() {
		initializeComponents();
		addComponents();
	}
	
	private void addComponents() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.weightx = 1;
		gbc.weighty = 0.1;
		gbc.fill = GridBagConstraints.BOTH;
		
		this.add(timeAmount, gbc);
		
		gbc.gridy = 1;
		gbc.weighty = 1;
		this.add(timerBar, gbc);
	}
	
	private void initializeComponents() {
		timeFont = new Font("Calibri", Font.BOLD, 40);
		timeAmount = new JLabel("0");
		
		timeAmount.setFont(timeFont);
		timeAmount.setBackground(Color.GRAY);
		timeAmount.setOpaque(true);
		timeAmount.setForeground(Color.YELLOW);
		timeAmount.setHorizontalAlignment(JLabel.CENTER);
		
		timerBar = new JProgressBar();
		timerBar.setMaximum(30);
		timerBar.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
	}
	
	private void setTimer(int time) {
		String timeString = String.valueOf(time);
		timerBar.setValue(time);
		timeAmount.setText(timeString);
		
		switch (time) {
		case 30: 
			timerBar.setBackground(Color.CYAN);
			break;
		case 15:
			timerBar.setBackground(Color.YELLOW);
			break;
		case 7:
			timerBar.setBackground(Color.RED);
			break;
		}
	}
	
}
