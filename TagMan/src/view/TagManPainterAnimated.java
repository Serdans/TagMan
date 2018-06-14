package view;
import model.AnimationFrame;

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
		String frameDir = "";
		
		// Fetch what animation frame should be drawn.
		switch (man.getCurrentAnimationFrame()) {
		case MOVE0:
			frameDir = "resources/man00.png";
			break;
		case MOVE1:
			frameDir = "resources/man01.png";
			break;
		case MOVE2:
			frameDir = "resources/man02.png";
			break;
		case MOVE3:
			frameDir = "resources/man03.png";
			break;
		case MOVE4:
			frameDir = "resources/man04.png";
			break;
		case MOVE5:
			frameDir = "resources/man05.png";
			break;
		case FINISHED:
			frameDir = "resources/man06.png";
			break;
		case HIT:
			frameDir = "resources/man07.png";
			break;
		default:
			System.out.println("Unknown animation frame..");
		}
		
		try {
			image = ImageIO.read(new File(frameDir));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int xPosToDraw = man.getX() - man.getWidth() / 2;
		int yPosToDraw = man.getY() - man.getHeight() / 2;
		
		g.drawImage(image, xPosToDraw, yPosToDraw, man.getWidth(), man.getHeight(), null);
	}
	
}
