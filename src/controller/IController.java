package controller;

import factory.Shape;

public interface IController {
	public void left();
	public void right();
	public void down();
	public void setNormalSpeed();
	public void rotate();
	public void pause();
	public void resume();
	public void restart();
	public Shape getCurrentShape();
	public Shape getNextShape();
}
