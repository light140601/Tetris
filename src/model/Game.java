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
<<<<<<< HEAD
		return null;
=======
		return new ShapeRandomFactory();
>>>>>>> 7388907dfa1527818ae111784bd7e69bdc573b36
	}

	@Override
	public void init() {
<<<<<<< HEAD
=======
		currentShape = this.shapeRandomFactory().creatShape('?', tileSize, this);		
>>>>>>> 7388907dfa1527818ae111784bd7e69bdc573b36
	}

	@Override
	public void update() {
<<<<<<< HEAD
=======
		currentShape.update();
		// update cho observer
		super.setChanged();
		super.notifyObservers();
>>>>>>> 7388907dfa1527818ae111784bd7e69bdc573b36
	}

	@Override
	public void draw(Graphics g) {
<<<<<<< HEAD
=======
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
>>>>>>> 7388907dfa1527818ae111784bd7e69bdc573b36
	}

	@Override
	public void setNextShape() {
<<<<<<< HEAD
=======
		currentShape = shapeRandomFactory().creatShape('?', tileSize, this);
	
>>>>>>> 7388907dfa1527818ae111784bd7e69bdc573b36
	}

	@Override
	public void setCurrentShape() {
<<<<<<< HEAD
=======
		// ...
>>>>>>> 7388907dfa1527818ae111784bd7e69bdc573b36
	}

	@Override
	public void checkLine() {
<<<<<<< HEAD
=======
		// ...
>>>>>>> 7388907dfa1527818ae111784bd7e69bdc573b36
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

	@Override
	public int[][] getBoard() {
		return board;
	}
}
