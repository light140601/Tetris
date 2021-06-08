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

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println(123);
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNextShape() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCurrentShape() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkLine() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Shape getNextShape() {
		return null;
	}

	@Override
	public Shape getCurrentShape() {
		return null;
	}
}
