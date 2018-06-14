package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.TagMan;

public class TagManPainterAnimated implements ITagManPainter {

	@Override
	public void paint(Graphics g, PlayView view, TagMan man) {
		
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(new File("resources/man00.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int xPosToDraw = man.getX() - man.getWidth() / 2;
		int yPosToDraw = man.getY() - man.getHeight() / 2;
		
		g.drawImage(image, xPosToDraw, yPosToDraw, man.getWidth(), man.getHeight(), null);
	}
	
}
