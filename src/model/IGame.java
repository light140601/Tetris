package model;

import java.awt.Graphics;

import controller.IController;

public interface IGame extends IController{
	public void init();

	public void update();

	public void draw(Graphics g);

	public void setNextShape();

	public void setCurrentShape();

	public void checkLine();

}
