package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.Dash;
import model.TagMan;

public class PlayView extends JPanel implements Observer {

	private TagManPainterPlain manPainter;
	
	public PlayView() {
		this.setPreferredSize(new Dimension(1000, 800));
		
		this.setBackground(Color.BLUE);
		
		manPainter = new TagManPainterPlain();
	}

	@Override
	public void update(Observable o, Object object) {
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	}
	
	private void drawTagMan(Graphics g, TagMan man) {
		
		manPainter.paint(g, this, man);
	}
	
	private void drawDashes(Dash[] dashes, Graphics g) {
		// Draw all dashes on the screen.
		for (Dash dash : dashes) {
			int xPos = dash.getX();
			int yPos = dash.getY();
			
			int width = dash.getWidth();
			int height = dash.getHeight();
			
			g.fillRect(xPos, yPos, width, height);
		}
	}
	
}
