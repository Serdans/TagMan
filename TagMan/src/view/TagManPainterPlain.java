package view;

import java.awt.Color;
import java.awt.Graphics;

import model.TagMan;

public class TagManPainterPlain implements ITagManPainter {

	@Override
	public void paint(Graphics g, PlayView view, TagMan man) {
		int xPos = man.getX();
		int yPos = man.getY();
		
		int width = man.getWidth();
		int height = man.getHeight();
		
		g.setColor(Color.RED);
		g.fillOval(xPos, yPos, width, height);
	}
	
}
