package view;

import java.util.Observable;

import javax.swing.JFrame;

import controller.IController;

public class View extends JFrame implements IView{
	private IController controller;
	private BoardGamePanel boardGamePn;
	private ScorePanel scorePn;
	private OptionPanel optionPn;
	
	public View(IController controller, Observable observable) {
		this.controller = controller;
		boardGamePn = new BoardGamePanel(this, observable);
		init();
	}

	@Override
	public void init() {
		
		setSize(1280,860);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void pause() {
		controller.pause();
	}

	@Override
	public void resume() {
		controller.resume();
	}

	@Override
	public void restart() {
		controller.restart();
	}

	public static void main(String[] args) {
		new View(null, null);
	}
}
