package view;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import factory.Shape;

public class NextShapePanel implements Observer {
	private Shape nextShape;
	private IView view;

	public NextShapePanel(IView view, Observable observable) {
		this.view = view;
		observable.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}
}
