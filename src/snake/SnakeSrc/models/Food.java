package snake.models;

import java.awt.Color;
import java.awt.Graphics;

public class Food extends Sprite {
	public static final int SIZE_X = 15;
	public static final int SIZE_Y = 15;
	private static final Color COLOR = new Color(10, 50, 188);

	public Food(int x, int y) {
		super(x, y, SIZE_X, SIZE_Y);
	}
	
	public void relocate() {
		int r  = (int) (Math.random() * 800);
		x = r;
		r = (int) (Math.random() * 800);
		y = r;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void draw(Graphics g) {
		Color savedCol = g.getColor();
		g.setColor(COLOR);
		g.fillOval(getX() - SIZE_X / 2, getY() - SIZE_Y / 2, SIZE_X, SIZE_Y);
		g.setColor(savedCol);
	}
}

