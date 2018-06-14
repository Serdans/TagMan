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
import java.util.ArrayList;
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

	private TagManPainterAnimated aniPainter;
	private Game game;
	private Message gameMessage;
	
	public PlayView(Game game) {
		this.game = game;
		
		int arenaWidth = game.getArenaWidth();
		int arenaHeight = game.getArenaHeight();
		
		game.addObserver(this);
		aniPainter = new TagManPainterAnimated();
		this.setPreferredSize(new Dimension(arenaWidth, arenaHeight));
		this.setBackground(Color.BLUE);
		this.setFocusable(true);
		this.requestFocus();
		
		// Message that's displayed on startup.
		gameMessage = new Message(game);
		gameMessage.setWelcomeMessage();
		
		this.setLayout(new GridBagLayout());
		this.add(gameMessage, null);
	}

	public void setBeginningLevelMessage() {
		gameMessage.setPreLevelStartMessage();
	}
	
	public void setWonMessage() {
		gameMessage.setWonMessage();
	}
	
	@Override
	public void update(Observable o, Object object) {
		if (game.levelInprogress()) {
			if (gameMessage.isVisible()) {
				gameMessage.setVisible(false);
			}
		}
		if (game.getTagMan().getDead()) {
			gameMessage.setVisible(true);
			gameMessage.setGameOverMessage();
		}
		if (game.getTagMan().getFinished() && !game.getGameOver()) {
			gameMessage.setVisible(true);
			gameMessage.setLevelOverMessage();
		}
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		drawStandardWalls(g);
		drawDashes(g);
		drawTagMan(g);
	}
	
	private void drawTagMan(Graphics g) {
		aniPainter.paint(g, this, game.getTagMan());
	}
	
	
	private void drawStandardWalls(Graphics g) {
		Wall[] standardWalls = game.getStandardWalls();
		for (Wall wall : standardWalls) {
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(wall.getX(), wall.getY(), wall.getWidth(), wall.getHeight());
			g.setColor(Color.GRAY);
			g.fillRect(wall.getX() + 10, wall.getY() + 10, wall.getWidth() - 20, wall.getHeight() - 20);
		}
		
		ArrayList<Wall> levelWalls = game.getLevelWalls();
		
		for (Wall wall : levelWalls) {
			g.setColor(Color.LIGHT_GRAY); 
			g.fillRect(wall.getX(), wall.getY(), wall.getWidth(), wall.getHeight());
			g.setColor(new Color(38, 39, 40)); // Really dark gray.
			g.fillRect(wall.getX() + 5, wall.getY() + 5, wall.getWidth() - 10, wall.getHeight() - 10);
		}
	}
	
	private void drawDashes(Graphics g) {
		Dash[] dashes = game.getDashes();
		// Draw all dashes on the screen.
		for (Dash dash : dashes) {
			int xPos = dash.getX();
			int yPos = dash.getY();
			
			int width = dash.getWidth();
			int height = dash.getHeight();
			
			g.setColor(Color.WHITE);
			g.fillRect(xPos, yPos, width, height);
			g.setColor(Color.RED);
			g.fillRect(xPos+1, yPos+1, width-2, height-2);
		}
	}
	
}
