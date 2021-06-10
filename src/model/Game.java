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


	public Game() {
	}

	public ShapeRandomFactory shapeRandomFactory() {

		return null;

//		return new ShapeRandomFactory();

	}

	public void init() {

//		currentShape = this.shapeRandomFactory().creatShape('?', tileSize, this);		

	}

	public void update() {

		currentShape.update();
		// update cho observer
		super.setChanged();
		super.notifyObservers();

	}

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

	public void setNextShape() {

//		currentShape = shapeRandomFactory().creatShape('?', tileSize, this);
	

	}

	public void setCurrentShape() {

		// ...

	}

	public void checkLine() {

		// ...

	}

	public Shape getNextShape() {
		return null;
	}

	public Shape getCurrentShape() {
		return this.currentShape;
	}
	
	public void pause() {
		pause=!pause;
	}

	

	public int[][] getBoard() {
		return board;
	}

	public int getTileSize() {
		// TODO Auto-generated method stub
		return this.tileSize;
	}
	
}
