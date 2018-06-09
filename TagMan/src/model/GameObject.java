package model;

public abstract class GameObject {

	private int width;
	private int height;
	
	private int xPos;
	private int yPos;
	
	public void moveObject(int x, int y) {
		xPos = xPos + x;
		yPos = yPos + y;
	}
	
	public void setX(int x) {
		this.xPos = x;
	}
	
	public int getX() {
		return xPos;
	}
	
	public void setY(int y) {
		this.yPos = y;
	}
	
	public int getY() {
		return yPos;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int length) {
		this.height = length;
	}

	
	
}
