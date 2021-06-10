package controller;

import factory.Shape;
import model.IGame;
import view.IView;

public class Controller implements IController {
	private IGame model;
	private IView view;

	public void left() {
	}

	public void right() {
	}

	public void down() {
	}

	public void setNormalSpeed() {
	}

	public void rotate() {
	}

	public void pause() {
	}

	public void resume() {
	}

	public void restart() {
	}

	public Shape getCurrentShape() {
		return null;
	}

	public Shape getNextShape() {
		return null;
	}

}
