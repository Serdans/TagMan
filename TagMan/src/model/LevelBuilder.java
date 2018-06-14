package model;

import java.util.ArrayList;

public class LevelBuilder {

	// This class creates levels.
	private Game game;
	private ArrayList<Wall> walls;
	
	public LevelBuilder(Game game) {
		this.game = game;
		this.walls = game.getLevelWalls();
	}
	
	public boolean buildLevel(int level) {
		boolean createdAnotherLevel = true;
		walls.clear();
		switch (level) {
		case 2:
			buildLevel2();
			break;
		default:
			createdAnotherLevel = false;
		}
		return createdAnotherLevel;
	}
	
	private void buildLevel2() {
		Wall wall = new Wall();
		wall.createNormalWall();
		wall.setX(game.getArenaWidth() * 2/5);
		wall.setY(game.getArenaHeight() * 1/4);
		
		walls.add(wall);
	}
	
	
}
