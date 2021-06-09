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

	public Game() {
	}

	public ShapeRandomFactory shapeRandomFactory() {
		return null;
	}

	@Override
	public void init() {
	}

	@Override
	public void update() {
	}

	@Override
	public void draw(Graphics g) {
	}

	@Override
	public void setNextShape() {
	}

	@Override
	public void setCurrentShape() {
	}

	@Override
	public void checkLine() {
	}

	@Override
	public Shape getNextShape() {
		return null;
	}

	@Override
	public Shape getCurrentShape() {
		return null;
	}

	@Override
	public int[][] getBoard() {
		return board;
	}
}
