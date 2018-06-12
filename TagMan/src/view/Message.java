package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Message extends JPanel {

	private JLabel message;
	
	public Message() {
		this.setPreferredSize(new Dimension(500, 200));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		
	}
	
}
