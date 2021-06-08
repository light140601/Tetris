package view;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

public class ScorePanel implements Observer{
	private IView view;

	public ScorePanel(IView view, Observable observable) {
		this.view = view;
		observable.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}
}
