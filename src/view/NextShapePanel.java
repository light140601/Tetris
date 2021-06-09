package view;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import factory.Shape;
import model.Game;

public class NextShapePanel extends JPanel implements Observer {
	private Shape nextShape;
	private IView view;

	public NextShapePanel(IView view, Observable observable) {
		this.view = view;
		observable.addObserver(this);
	}

	public void update(Observable o, Object arg) {
		if(o instanceof Game) {
			Game game = (Game) o;
			nextShape = game.getNextShape();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}
