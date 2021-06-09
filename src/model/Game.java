package model;

import java.awt.Graphics;
import java.util.Observable;

import factory.Shape;
import factory.ShapeRandomFactory;

public class Game extends Observable implements IGame {
	private int[][] board;
	private int tileSize; // kich thuoc tung khoi
	private boolean pause;
	private boolean gameOver;

	public Game(int[][] board, int tileSize, boolean pause, boolean gameOver) {
		this.board = board;
		this.tileSize = tileSize;
		this.pause = pause;
		this.gameOver = gameOver;
	}

	public ShapeRandomFactory shapeRandomFactory() {
		// insert code
		return null;
	}

	public void init() {
		// TODO Auto-generated method stub
		System.out.println(123);
		
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	public void setNextShape() {
		// TODO Auto-generated method stub
		
	}

	public void setCurrentShape() {
		// TODO Auto-generated method stub
		
	}

	public void checkLine() {
		// TODO Auto-generated method stub
		
	}

	public Shape getNextShape() {
		return null;
	}

	public Shape getCurrentShape() {
		return null;
	}

	public int[][] getBoard() {
		return board;
	}
	
}
