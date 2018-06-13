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
import javax.swing.JProgressBar;

import controller.TimeController;

public class TimeView extends JPanel implements Observer {

	private TimeController tc;
	private Font timeFont;
	private JLabel timeText;
	private JLabel timeAmount;
	private JProgressBar timerBar;
	
	public TimeView() {
		initializeComponents();
		addComponents();
	}
	
	public void setTimeController(TimeController tc) {
		this.tc = tc;
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
		gbc.weighty = 0.5;
		gbc.insets = new Insets(10, 40, 10, 40);
		this.add(timerBar, gbc);
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.weighty = 1;
		gbc.gridy = 2;
		this.add(timeText, gbc);
	}
	
	private void initializeComponents() {
		timeFont = new Font("Calibri", Font.BOLD, 40);
		timeAmount = new JLabel("0");
		timeText = new JLabel("seconds");
		
		
		timeAmount.setFont(timeFont);
		timeAmount.setBackground(Color.GRAY);
		timeAmount.setOpaque(true);
		timeAmount.setForeground(Color.YELLOW);
		timeAmount.setHorizontalAlignment(JLabel.CENTER);
		
		timeText.setBackground(Color.GRAY);
		timeText.setOpaque(true);
		timeText.setForeground(Color.YELLOW);
		timeText.setHorizontalAlignment(JLabel.CENTER);
		
		timerBar = new JProgressBar(JProgressBar.VERTICAL);
		timerBar.setMaximum(30);
		timerBar.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
	}
	
	public void setTimer(int time) {
		String timeString = String.valueOf(time);
		timerBar.setValue(time);
		timeAmount.setText(timeString);
		
		switch (time) {
		case 30:
			timerBar.setForeground(Color.CYAN);
			break;
		case 15:
			timerBar.setForeground(Color.YELLOW);
			break;
		case 7:
			timerBar.setForeground(Color.RED);
			break;
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		setTimer(tc.getTime());
	}
	
}
