package model;

import java.awt.Graphics;
import java.util.Observable;

import factory.Shape;
import factory.ShapeRandomFactory;

public class Game extends Observable implements IGame {
	// game là model trong mvc, là observable của view

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
		// currentShape = new ShapeRandomFactory().creatShape(0, 0, tileSize); 
	}

	public void update() {
		currentShape.update();
		// update cho observer
		super.setChanged();
		super.notifyObservers();

	}

	public void draw(Graphics g) {
		currentShape.draw(g);
		update();
		// ...
	}

	public void setNextShape() {
		// tạo sẵn shape tiếp theo
		nextShape = new ShapeRandomFactory().creatShape(0, 0, tileSize);
		// check còn tạo shape mới dc ko
		for (int row = 0; row < currentShape.getCoords().length; row++) {
			for (int col = 0; col < currentShape.getCoords()[row].length; col++) {
				if (currentShape.getCoords()[row][col] != 0) {
					if (board[row][col + 3] != 0) // +3
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
		// khi 1 hàng đầy thì hàng đó sẽ bị bỏ đi
		int height = board.length - 1;
		for (int row = height; row > 0; row--) {
			int count = 0;
			for (int col = 0; col < board[0].length; col++) {
				if (board[row][col] != 0) {
					count++;
				}
				board[height][col] = board[row][col]; // (1*) nếu hàng đầy thì sẽ bị thay thế bởi hàng trên
			}
			if (count < board[0].length)
				height--; // hàng chưa đầy nên tiếp tục đếm lên hàng trên
			// else (1*)
		}

	}

	public Shape getNextShape() {
		return this.nextShape;
	}

	public Shape getCurrentShape() {
		return this.currentShape;
	}

	public void pause() {
		pause = !pause;
	}

	public int[][] getBoard() {
		return board;
	}

	public int getTileSize() {
		return this.tileSize;
	}
	

	public void resume() {
		// ...
	}

}
