package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import model.Dash;
import model.Game;
import model.TagMan;
import model.Wall;

public class PlayView extends JPanel implements Observer {

	private TagManPainterPlain manPainter;
	private Game game;
	
	private JPanel welcomePanel;
	private JLabel welcomeMessage;
	
	private static final String MOVE_UP = "move up";
	
	public PlayView(Game game) {
		this.game = game;
		
		int arenaWidth = game.getArenaWidth();
		int arenaHeight = game.getArenaHeight();
		
		game.addObserver(this);
		manPainter = new TagManPainterPlain();
		this.setPreferredSize(new Dimension(arenaWidth, arenaHeight));
		this.setBackground(Color.BLUE);
		this.setFocusable(true);
		this.requestFocus();
	}

	@Override
	public void update(Observable o, Object object) {
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		drawStandardWalls(g);
		drawTagMan(g);
	}
	
	private void drawTagMan(Graphics g) {
		manPainter.paint(g, this, game.getTagMan());
	}
	
	private void drawStandardWalls(Graphics g) {
		Wall[] standardWalls = game.getStandardWalls();
		
		for (Wall wall : standardWalls) {
			g.setColor(Color.GRAY);
			g.fillRect(wall.getX(), wall.getY(), wall.getWidth(), wall.getHeight());
			g.setColor(Color.LIGHT_GRAY);
			g.drawRect(wall.getX(), wall.getY(), wall.getWidth(), wall.getHeight());
		}
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
