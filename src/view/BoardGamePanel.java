package view;

import java.awt.Graphics;
import java.util.Observable;

import factory.Shape;

public class BoardGamePanel{
	private int[][] board;
	private Shape currentShape;

	public BoardGamePanel(int[][] board, Shape currentShape) {
		this.board = board;
		this.currentShape = currentShape;
	}

	public void update(Observable o, Object obj) {
		// insert code
	}

	public void paintComponent(Graphics g) {
		// insert code
	}
}
