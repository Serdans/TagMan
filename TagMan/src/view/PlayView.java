package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import model.Dash;
import model.Game;
import model.TagMan;

public class PlayView extends JPanel implements Observer {

	private TagManPainterPlain manPainter;
	private Game game;
	
	private static final String MOVE_UP = "move up";
	
	public PlayView(Game game) {
		this.game = game;
		game.addObserver(this);
		
		this.setPreferredSize(new Dimension(1000, 800));
		this.setBackground(Color.BLUE);
		
		addListeners();
		manPainter = new TagManPainterPlain();
		this.setFocusable(true);
		this.requestFocus();
	}

	@Override
	public void update(Observable o, Object object) {
		repaint();
	}
	
	private void addListeners() {
		this.getInputMap().put(KeyStroke.getKeyStroke("UP"), MOVE_UP);
	}
	
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawTagMan(g);
	}
	
	private void drawTagMan(Graphics g) {
		manPainter.paint(g, this, game.getTagMan());
	}
	
	private void drawWall(Graphics g) {
		
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
