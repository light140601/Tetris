package view;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

public class OptionPanel implements Observer{
	private IView view;
	private JButton restart;
	private JButton pause;
	private JButton tutorial;
	private JButton home;
	private JButton exit;
	
	public OptionPanel(IView view, Observable observable) {
		this.view = view;
		observable.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}
}
