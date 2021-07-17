package view.tutorial;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import translation.Translation;
import model.Game;

public class Tutorial extends JDialog implements Observer {

	private JLabel title, content;
	private JButton cancleBt;

	public Tutorial(Observable observableLanguage) {
		observableLanguage.addObserver(this);

		this.getContentPane().setBackground(new Color(227, 238, 255));
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		add(title = new JLabel());
		title.setPreferredSize(new Dimension(400, 100));
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(new Font(Font.DIALOG, Font.BOLD, 28));
		add(content = new JLabel());

		content.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
		add(cancleBt = new JButton());
		cancleBt.setPreferredSize(new Dimension(75, 30));
		cancleBt.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cancleBt.setBackground(new Color(240, 205, 139));
		cancleBt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				cancleBt.setBackground(new Color(240, 177, 60));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				cancleBt.setBackground(new Color(240, 205, 139));
			}
		});

		setSize(400, 520);
		setResizable(false);
		setLocationRelativeTo(null);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Translation) {
			Translation tran = (Translation) o;
			this.setTitle(tran.getTutorialName());
			title.setText(tran.getTutorialName());
			content.setIcon(new ImageIcon(tran.getTutorialImageName()));
			if (cancleBt != null)
				cancleBt.setText(tran.getCancleName());
		}

	}
}
