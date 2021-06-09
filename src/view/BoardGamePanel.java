package view;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import factory.Shape;

public class BoardGamePanel extends JPanel implements Observer{
	private int[][] board;
	private Shape currentShape;
	private IView view;

	public BoardGamePanel(IView view, Observable observable) {
		this.view = view;
		observable.addObserver(this);
	}

	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
