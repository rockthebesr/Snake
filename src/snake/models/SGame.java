package snake.models;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;

public class SGame {
	public static final int WIDTH = 800;
	public static final int HEIGHT = WIDTH;

	Snake snake1;
	Snake snake2;
	List<Snake> snakes = new LinkedList<Snake>();

	List<Food> foods = new LinkedList<Food>();

	Food food1;
	Food food2;

	boolean isGameOver;

	Head head1;
	Head head2;
	List<Head> heads = new LinkedList<Head>();

	public SGame() {
		setup();
	}

	public void setup() {
		snake1 = new Snake(WIDTH / 2 - 200, HEIGHT / 2);
		snake2 = new Snake(WIDTH / 2, HEIGHT / 2 + 200);
		snakes.add(snake1);
		snakes.add(snake2);

		head1 = snake1.getHead();
		head2 = snake2.getHead();
		heads.add(head1);
		heads.add(head2);

		food1 = new Food(head1.getX(), head1.getY() + 100);
		food2 = new Food(head2.getX() + 100, head2.getY());
		foods.add(food1);
		foods.add(food2);

		isGameOver = false;
	}

	public void update() {
		moveSnake();
		checkCollision(snake1, foods);
		checkCollision(snake2, foods);
		isGameOver();
	}

	public boolean isGameOver() {
		if (snake1.checkSnakeCollisions() || snake2.checkSnakeCollisions()) {
			isGameOver = true;
			return true;}
		else for (Head next: heads) {
			int x = next.getX();
			int y = next.getY();
			isGameOver =  (x >= WIDTH || x < 0 || y >= HEIGHT || y < 0);
			if (isGameOver)
				return true;

		}
		return false;
	}



	private void checkCollision(Snake snake, List<Food> foods) {
		Head head = snake.getHead();
		Rectangle thisBoundingRect = new Rectangle(head.getX() - head.getWidth() / 2, head.getY() - head.getHeight() / 2, head.getWidth(), head.getHeight());
		for (Food other: foods) {
			Rectangle otherBoundingRect = new Rectangle(other.getX() - other.getWidth() / 2, other.getY() - other.getHeight() / 2,
					other.getWidth(), other.getHeight());
			boolean hit = thisBoundingRect.intersects(otherBoundingRect);
			if (hit) {
				other.relocate();
				snake.addTail();
			}}
	}

	private void moveSnake() {
		snake1.move();
		snake2.move();
	}

	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if ((e.getKeyCode() == KeyEvent.VK_KP_LEFT || e.getKeyCode() == KeyEvent.VK_LEFT) && !snake1.isRight())
			snake1.faceLeft();
		if ((e.getKeyCode() == KeyEvent.VK_KP_RIGHT || e.getKeyCode() == KeyEvent.VK_RIGHT) && !snake1.isLeft())
			snake1.faceRight();
		if ((e.getKeyCode() == KeyEvent.VK_KP_DOWN || e.getKeyCode() == KeyEvent.VK_DOWN) && !snake1.isUp())
			snake1.faceDown();
		if ((e.getKeyCode() == KeyEvent.VK_KP_UP || e.getKeyCode() == KeyEvent.VK_UP) && !snake1.isDown())
			snake1.faceUp();
		
		if (e.getKeyCode() == KeyEvent.VK_A && !snake2.isRight())
			snake2.faceLeft();
		if (e.getKeyCode() == KeyEvent.VK_D && !snake2.isLeft())
			snake2.faceRight();
		if (e.getKeyCode() == KeyEvent.VK_S && !snake2.isUp())
			snake2.faceDown();
		if (e.getKeyCode() == KeyEvent.VK_W && !snake2.isDown())
			snake2.faceUp();
		
		if (e.getKeyCode() == KeyEvent.VK_R && isGameOver)
			setup();
		if (key == KeyEvent.VK_X)
			System.exit(0);
	}

	public Snake getSnake() {
		return this.snake1;
	}

	public Food getFood1(){
		return this.food1;
	}

	public void draw(Graphics g) {
		for(Snake next: snakes) {
			next.draw(g);
		}
		for(Food food: foods) {
			food.draw(g);
		}
	}


}
