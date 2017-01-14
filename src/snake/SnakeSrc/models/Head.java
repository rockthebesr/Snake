package snake.models;

import java.awt.Color;
import java.awt.Graphics;

public class Head extends Sprite {

	private static final int SIZE_X = 15;
	private static final int SIZE_Y = 15;
	private static final Color COLOR = new Color(250, 128, 20);
	
	public Head(int x, int y) {
		super(x, y, SIZE_X, SIZE_Y);
	}


	@Override
	public void draw(Graphics g) {
		Color savedCol = g.getColor();
		g.setColor(COLOR);
		g.fillRect(getX() - SIZE_X / 2, getY() - SIZE_Y / 2, SIZE_X, SIZE_Y);
		g.setColor(savedCol);

	}


	public void moveLeft() {
		x = x - 3;
	}


	public void moveRight() {
		x = x + 3;
	}


	public void moveDown() {
		y = y + 3;
	}


	public void moveUp() {
		y = y - 3;
	}

}
