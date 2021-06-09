package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.IController;

public class View extends JFrame implements IView {
	private IController controller;
	private BoardGamePanel boardGamePn;
	private NextShapePanel nextShapePn;
	private ScorePanel scorePn;
	private OptionPanel optionPn;
	private JPanel rightPn;

	public View(IController controller, Observable observable) {
		this.controller = controller;
		if (observable != null) {
			boardGamePn = new BoardGamePanel(this, observable);
			nextShapePn = new NextShapePanel(this, observable);
			scorePn = new ScorePanel(this, observable);
			optionPn = new OptionPanel(this, observable);
		}
		init();
	}

	public void init() {
		setLayout(new BorderLayout(10, 10));
		add(boardGamePn, BorderLayout.CENTER);

		add(rightPn = new JPanel(), BorderLayout.EAST);
		rightPn.setLayout(new FlowLayout(10, 10, 10));
		rightPn.add(nextShapePn);
		rightPn.add(scorePn);
		rightPn.add(optionPn);

		setSize(1280, 860);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void pause() {
		controller.pause();
	}

	public void resume() {
		controller.resume();
	}

	public void restart() {
		controller.restart();
	}

	public static void main(String[] args) {
		new View(null, null);
	}
}
