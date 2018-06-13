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

		int width2 = width * 4/5;
		int height2 = height * 4/5;
		int xPosToDraw2 = xPosToDraw + width2 / 2;
		int yPosToDraw2 = yPosToDraw + height / 2;
		
		g.setColor(Color.ORANGE);
		g.fillOval(xPosToDraw2, yPosToDraw2, width2, height2);
		
	}
	
}
