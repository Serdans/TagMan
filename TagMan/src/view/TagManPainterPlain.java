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
		
		int xPosToDraw = xPos - width / 2;
		int yPosToDraw = yPos - height / 2;
		
		g.setColor(Color.RED);
		g.fillOval(xPosToDraw, yPosToDraw, width, height);

	}
	
}
