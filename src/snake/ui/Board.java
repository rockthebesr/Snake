package snake.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;

import snake.models.*;

@SuppressWarnings("serial")
public class Board extends JPanel {
	private static final String OVER = "Game Over!";

	private SGame game;

	public Board(SGame game) {
		setPreferredSize(new Dimension(SGame.WIDTH, SGame.HEIGHT));
		setBackground(Color.GRAY);
		this.game = game;
	}


	@Override
	protected void paintComponent(Graphics g) { 
		super.paintComponent(g);
		
		drawGame(g);
		
		if (game.isGameOver()) {
			gameOver(g);
		}
	}
	
	private void gameOver(Graphics g) {
		Color saved = g.getColor();
		g.setColor(new Color( 0, 0, 0));
		g.setFont(new Font("Arial", 20, 20));
		FontMetrics fm = g.getFontMetrics();
		centreString(OVER, g, fm, SGame.HEIGHT / 2);
		g.setColor(saved);
	}


	private void centreString(String str, Graphics g, FontMetrics fm, int yPos) {
		int width = fm.stringWidth(str);
		g.drawString(str, (SGame.WIDTH - width) / 2, yPos);
	}

	// Draws the game
	// modifies: g
	// effects:  the game is drawn onto the Graphics object g
	private void drawGame(Graphics g) {
		game.draw(g);
	}
	

}
