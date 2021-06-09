package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import factory.Shape;
import model.Game;

public class BoardGamePanel extends JPanel implements Observer {
	private int[][] board;
	private Shape currentShape;
	private IView view;
	private int tileSize;

	public BoardGamePanel(IView view, Observable observable) {
		this.view = view;
		observable.addObserver(this);
		init();
	}

	public void init() {
		board = new int[20][15];
		tileSize = 45;
		setPreferredSize(new Dimension(board[0].length * tileSize, board.length * tileSize));
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Game) {
			Game game = (Game) o;
			board = game.getBoard();
			currentShape = game.getCurrentShape();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < board[0].length; i++) {
			g.drawLine(i * tileSize, 0, i * tileSize, getHeight());
		}
		for (int i = 0; i < board.length; i++) {
			g.drawLine(0, i * tileSize, getWidth(), i * tileSize);
		}
	}
}
