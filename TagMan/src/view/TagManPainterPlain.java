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
		
		// Set default colors.
		Color color1 = Color.RED;
		Color color2 = Color.ORANGE;
		Color color3 = Color.YELLOW;
		
		if (man.getFinished()) {
			color1 = new Color(25, 89, 32); // Dark green.
			color2 = Color.GREEN;
			color3 = new Color(84, 247, 100); // Light green
		} 
		
		g.setColor(color1);
		g.fillOval(xPosToDraw, yPosToDraw, width, height);

		width -= width / 5;
		height -= height / 5;
		g.setColor(color2);
		// Draw a circle inside the bigger circle. Also keep calculating the circle's offset.
		// The offset changes with the width / height / size.
		g.fillOval(xPos - (width / 2), yPos - (width / 2), width, height);
		
		width -= width / 4;
		height -= height / 4;
		g.setColor(color3);
		g.fillOval(xPos - (width / 2), yPos - (width / 2), width, height);
		
		
	}
	
}
