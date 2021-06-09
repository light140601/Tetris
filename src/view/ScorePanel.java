package view;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class ScorePanel extends JPanel implements Observer{
	private IView view;

	public ScorePanel(IView view, Observable observable) {
		this.view = view;
		observable.addObserver(this);
	}

	public void update(Observable o, Object arg) {
		
	}
}
