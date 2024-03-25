package cz.cvut.fel.ass;

/**
 * Tato trida slouzi k udrzovani informace o poloze robota
 */
public class Position {

	private int x, y;
	private String curentDirection;
	public static final String[] DIRECTIONS = { "UP", "LEFT", "RIGHT", "DOWN" };

	public Position(int x, int y, String direction) {
		this.x = x;
		this.y = y;
		this.curentDirection = direction;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getDirection() {
		return this.curentDirection;
	}

	public void setDirection(String direction) {
		this.curentDirection = direction;
	}

}
