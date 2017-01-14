package snake.models;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;


public class Snake {
	public Head head;
	public List<Body> body;
	
	private boolean leftD = false;
	private boolean rightD = true;
	private boolean downD = false;
	private boolean upD = false;

	public Snake(int x, int y) {
		head = new Head(x, y);
		body = new LinkedList<Body>();
	}

	public void move() {

		for (int z = body.size() - 1; z > 0; z--) {
			body.get(z).setX(body.get(z - 1).getX());
			body.get(z).setY(body.get(z - 1).getY());
			
			body.get(0).setX(head.getX());
			body.get(0).setY(head.getY());
			
		}
		
			if (leftD) {
				head.moveLeft();
			}
			
			if (rightD) {
				head.moveRight();
			}
			
			if (downD) {
				head.moveDown();
			}
			
			if (upD) {
				head.moveUp();
			}
		
	}
	
	public int getLength() {
		return 1 + body.size();
	}
	
	public boolean checkSnakeCollisions() {
		for (int z = body.size() -1; z >= 0; z--) {
			if (head.getX() == body.get(z).getX() 
					&&
					head.getY() == body.get(z).getY())
				return true;
		}
		
		return false;
	}
	
	public Head getHead() {
		return head;
	}
	
	
	public void addTail(){
		if (body.size() == 0) {
			int x = head.getX();
			int y = head.getY();
			Body e = new Body(x+ 10, y);
			body.add(e);
		}
		
		int x = body.get(body.size() - 1).getX();
		int y = body.get(body.size() - 1).getY();
		Body tail = new Body(x + 10, y + 10);
		body.add(tail);
	}
	
	public void faceLeft() {
		leftD = true;
		rightD = false;
		upD = false;
		downD = false;
	}
	
	public void faceRight() {
		leftD = false;
		rightD = true;
		upD = false;
		downD = false;
	}
	
	public void faceDown() {
		leftD = false;
		rightD = false;
		upD = false;
		downD = true;
	}
	
	public void faceUp() {
		leftD = false;
		rightD = false;
		upD = true;
		downD = false;
	}
	
	public boolean isRight() {
		return rightD;
	}
	
	public boolean isLeft() {
		return leftD;
	}
	
	public boolean isDown() {
		return downD;
	}
	
	public boolean isUp() {
		return upD;
	}
	
	public void draw(Graphics g) {
		head.draw(g);
		for (Body next: body) {
			next.draw(g);
		}
	}
}
