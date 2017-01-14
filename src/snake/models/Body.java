package snake.models;
import java.awt.Color;
import java.awt.Graphics;


public class Body extends Sprite {

	private static final int SIZE_X = 15;
	private static final int SIZE_Y = 15;
	private static final Color COLOR = new Color(128, 50, 20);
	
	public Body(int x, int y) {
		super(x, y, SIZE_X, SIZE_Y);
	}

	@Override
	public void draw(Graphics g) {
		Color savedCol = g.getColor();
		g.setColor(COLOR);
		g.fillOval(getX() - SIZE_X / 2, getY() - SIZE_Y / 2, SIZE_X, SIZE_Y);
		g.setColor(savedCol);
	}

}
