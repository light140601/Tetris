package model;

import java.awt.Graphics;

import factory.Shape;

public interface IGame {
	public void init();
	public void update();
	public void draw(Graphics g);

	public Shape getNextShape();
	public void setNextShape();
	public void setCurrentShape();

	public Shape getCurrentShape();
	public void checkLine();


	public int[][] getBoard();
	public int getTileSize();

}
