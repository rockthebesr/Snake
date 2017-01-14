package snake.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.Timer;

import snake.models.SGame;

@SuppressWarnings("serial")
public class Game extends JFrame {

	private static final int INTERVAL = 20;
	private SGame game;
	private Board board;
	private Timer t;

	public Game() {
		super("Snake");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		game = new SGame();
		board = new Board(game);
		add(board);
		addKeyListener(new KeyHandler());
		pack();
		centreOnScreen();
		setVisible(true);
		addTimer();
		t.start();
	}
	
	private void addTimer() {
		t = new Timer(INTERVAL, new GameTickerActionListener()
		);
	}
	
	private class GameTickerActionListener extends AbstractAction {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (!game.isGameOver()) {
				game.update();	
				board.repaint();
			} else {
				board.repaint();
				t.stop();
			}
		}
	}
	
	private void centreOnScreen() {
		Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
	}
	
	private class KeyHandler extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			game.keyPressed(e);
		}
	}
	
	// Play the game
	public static void main(String[] args) {
		new Game();
	}
}
