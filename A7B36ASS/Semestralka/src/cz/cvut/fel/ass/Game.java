package cz.cvut.fel.ass;

import cz.cvut.fel.ass.interpreter.GameContext;
import cz.cvut.fel.ass.interpreter.IllegalGameActionException;

public class Game extends GameContext {

	private Position currentPostion;
	private int sizeX = 10, sizeY = 10;
	private int[][] beepers;

	public Game() {
		resetGame();

	}

	public void resetGame() {
		beepers = new int[sizeX][sizeY];
		for (int i = 0; i < sizeX; i++)
			for (int j = 0; j < sizeY; j++)
				beepers[i][j] = 0;
		// na zacatku nastavim pozici na [0,0] a orientaci vpravo
		this.currentPostion = new Position(0, 0, Position.DIRECTIONS[2]);
	}

	@Override
	public void move() throws IllegalGameActionException {
		System.out.println("Pohybuji se");
		doMove();
		echoLocation();
	}

	@Override
	public void pick() throws IllegalGameActionException {
		try {
			grabBeeper(currentPostion.getX(), currentPostion.getY());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	@Override
	public void put() throws IllegalGameActionException {
		putBeeper(currentPostion.getX(), currentPostion.getY());

	}

	@Override
	public void turnLeft() throws IllegalGameActionException {
		String direct = currentPostion.getDirection();
		currentPostion.setDirection((direct.equals("LEFT")) ? "DOWN" : (direct
				.equals("DOWN")) ? "RIGHT" : (direct.equals("RIGHT")) ? "UP"
				: "LEFT");
		echoDirection();
	}

	public void echoLocation() {
		System.out.println("Pozice:[" + currentPostion.getX() + ","
				+ currentPostion.getY() + "]");
	}

	public void echoDirection() {
		System.out.println("Orientace:" + currentPostion.getDirection());
	}

	public void putBeeper(int x, int y) {
		beepers[x][y] += 1;
	}

	public void grabBeeper(int x, int y) throws Exception {
		if (beepers[x][y] > 0)
			beepers[x][y]--;
		else
			throw new Exception("No beeper in here");
	}

	public void doMove() {
		String direct = currentPostion.getDirection();
		try {
			if (direct.equals("UP") || direct.equals("DOWN")) {
				if (direct.equals("UP") && currentPostion.getY() == 0)
					throw new Exception("End of game desk.");
				else if (direct.equals("DOWN")
						&& currentPostion.getY() == this.sizeY)
					throw new Exception("End of game desk.");
				else
					currentPostion
							.setY((direct.equals("DOWN")) ? currentPostion
									.getY() + 1 : currentPostion.getY() - 1);
			} else {
				if (direct.equals("LEFT") && currentPostion.getX() == 0)
					throw new Exception("End of game desk.");
				else if (direct.equals("RIGHT")
						&& currentPostion.getX() == this.sizeX)
					throw new Exception("End of game desk.");
				else
					currentPostion
							.setX((direct.equals("LEFT")) ? currentPostion
									.getX() - 1 : currentPostion.getX() + 1);
			}
		} catch (Exception ex) {
			System.err.println("Robot vyšel mimo desku");
			halt();
		}
>>>>>>> f00c29411566e51d00213eb6a5c1c6b6d6800588
	}

	@Override
	public void halt() {
		// TODO Auto-generated method stub

	}

}
