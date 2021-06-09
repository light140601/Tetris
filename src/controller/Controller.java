package controller;

import factory.Shape;
import model.IGame;
import view.IView;

public class Controller implements IController {
	private IGame model;
	private IView view;

	@Override
	public void left() {
	}

	@Override
	public void right() {
	}

	@Override
	public void down() {
	}

	@Override
	public void setNormalSpeed() {
	}

	@Override
	public void rotate() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void restart() {
	}

	@Override
	public Shape getCurrentShape() {
		return null;
	}

	@Override
	public Shape getNextShape() {
		return null;
	}

}
