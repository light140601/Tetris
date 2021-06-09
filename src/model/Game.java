package model;

import java.awt.Graphics;
import java.util.Observable;

import factory.Shape;
import factory.ShapeRandomFactory;

public class Game extends Observable implements IGame {
	// game là model trong mvc, là observable của view

	private int[][] board;
	private int tileSize; // kich thuoc tung khoi
	private boolean gameOver;
	private Shape currentShape;
	private boolean running = true;
	private boolean pause = false;
	private final Object pauseLock = new Object(); // pause


	public Game(int[][] board, int tileSize, boolean pause, boolean gameOver) {
		this.board = board;
		this.tileSize = tileSize;
		this.pause = pause;
		this.gameOver = gameOver;
	}

	public ShapeRandomFactory shapeRandomFactory() {
		return new ShapeRandomFactory();
	}

	@Override
	public void init() {
		currentShape = this.shapeRandomFactory().creatShape('?', tileSize, this);		
	}

	@Override
	public void update() {
		currentShape.update();
		// update cho observer
		super.setChanged();
		super.notifyObservers();
	}

	@Override
	public void draw(Graphics g) {
		while (running) {
			update();
			try {
				// draw board
				for (int row = 0; row < board.length; row++) {
					for (int col = 0; col < board[col].length; col++) {
						g.drawRect(row * tileSize, col * tileSize, tileSize, tileSize); // vẽ ô vuông
					}
				}

				// pause game
				if (pause) {
					try {
						pauseLock.wait();
					} catch (InterruptedException ex) {
						System.out.println("bug");
					}
				}

				// draw shape
				currentShape.draw(g);
				Thread.sleep(500);

				// ........
			} catch (InterruptedException e) {
				System.out.println("bug");
			}
		}
	}

	@Override
	public void setNextShape() {
		currentShape = shapeRandomFactory().creatShape('?', tileSize, this);
	
	}

	@Override
	public void setCurrentShape() {
		// ...
	}

	@Override
	public void checkLine() {
		// ...
	}

	@Override
	public Shape getNextShape() {
		return null;
	}

	@Override
	public Shape getCurrentShape() {
		return this.currentShape;
	}
	
	public void pause() {
		pause=!pause;
	}
}
