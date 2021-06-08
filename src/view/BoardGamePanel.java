package view;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import factory.Shape;

public class BoardGamePanel implements Observer{
	private int[][] board;
	private Shape currentShape;
	private IView view;

	public BoardGamePanel(IView view, Observable observable) {
		this.view = view;
		observable.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
