package model;

import java.awt.Graphics;
import java.util.Observable;

import factory.Shape;
import factory.ShapeRandomFactory;

public class Game extends Observable implements IGame {
	private int[][] board;
	private int tileSize; // kich thuoc tung khoi
	private Shape currentShape;
	private Shape nextShape;
	private boolean pause = false;
	private boolean gameOver;

	public Game() {
		board = new int[20][15];
		tileSize = 45;
	}

	public void init() {
		currentShape = new ShapeRandomFactory().creatShape(tileSize, this);
	}

	public void update() {
		currentShape.update();
		// update cho observer
		super.setChanged();
		super.notifyObservers();

	}

	public void draw(Graphics g) {
		currentShape.draw(g);
		// ...
	}

	public void setNextShape() {
		nextShape = new ShapeRandomFactory().creatShape(tileSize, this);
		for (int row = 0; row < currentShape.getCoords().length; row++) {
			for (int col = 0; col < currentShape.getCoords()[row].length; col++) {
				if (currentShape.getCoords()[row][col] != 0) {
					if (board[row][col + 3] != 0)
						gameOver = true;
				}
			}
		}
	}

	public void setCurrentShape() {
		currentShape = nextShape;
		this.setNextShape();
	}

	public void checkLine() {
		int height = board.length - 1;
		for (int row = height; row > 0; row--) {
			int count = 0;
			for (int col = 0; col < board[0].length; col++) {
				if (board[row][col] != 0) {
					count++;
				}
				board[height][col] = board[row][col];
			}
			if (count < board[0].length)
				height--;
		}

	}

	public Shape getNextShape() {
		return this.nextShape;
	}

	public Shape getCurrentShape() {
		return this.currentShape;
	}

	public int[][] getBoard() {
		return board;
	}

	public int getTileSize() {
		return this.tileSize;
	}

	public void left() {
		currentShape.left();
	}

	public void right() {
		currentShape.right();

	}

	public void down() {
		currentShape.down();
	}

	public void setNormalSpeed() {
		currentShape.setNormalSpeed();
	}

	public void rotate() {
		currentShape.rotate();
	}

	public void resume() {
		// ...
	}

	public void pause() {
		pause = !pause;
		// ...
	}

}
