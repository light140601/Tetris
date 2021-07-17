package view.high_score;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import translation.Translation;
import controller.IController;
import model.Game;
import obj.Player;
import obj.PlayerList;

public class HighScore extends JDialog implements Observer, IHighScore {

	private IController controller;
	private PlayerList players;
	private JLabel title;
	private ContentPn contentPn;
	private JPanel titlePn, btPn;
	private JButton cancleBt;
	private String titleFrame, highScore, player, score, rank;

	public HighScore(IController controller, Observable observableModel, Observable observableLanguage) {
		this.controller = controller;
		observableModel.addObserver(this);
		observableLanguage.addObserver(this);

		setLayout(new FlowLayout());
		this.getContentPane().setBackground(new Color(189, 215, 255));

		// component
		add(titlePn = new JPanel());
		titlePn.setBackground(new Color(189, 215, 255));
		titlePn.add(title = new JLabel(highScore));
		title.setPreferredSize(new Dimension(500, 100));
		title.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
		title.setHorizontalAlignment(JLabel.CENTER);
		add(contentPn = new ContentPn());
		add(btPn = new JPanel());
		btPn.setBackground(new Color(189, 215, 255));
		btPn.add(cancleBt = new JButton());
		cancleBt.setBackground(new Color(240, 205, 139));
		cancleBt.setPreferredSize(new Dimension(100, 30));
		cancleBt.setCursor(new Cursor(Cursor.HAND_CURSOR));
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

		setSize(500, 705);
		setTitle(titleFrame);
		setResizable(false);
		setLocationRelativeTo(null);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Game) {
			Game game = (Game) o;
			players = game.getPlayerList();
			if (players != null)
				sort();
			repaint();
		}

		if (o instanceof Translation) {
			Translation tran = (Translation) o;
			rank = tran.getRankName();
			this.setTitle(tran.getHighScoreName());
			player = tran.getPlayerName();
			score = tran.getScoreName();
			title.setText(tran.getHighScoreName());
			titleFrame = tran.getHighScoreName();
			if (cancleBt != null)
				cancleBt.setText(tran.getCancleName());
		}
	}

	@Override
	public void sort() {
		players.sort();
	}

	private class ContentPn extends JPanel {

		public ContentPn() {
			setPreferredSize(new Dimension(500, 500));
			setBackground(Color.WHITE);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
			g.drawString(rank, 40, 20);
			g.drawString(player, getWidth() / 2 - 20, 20);
			g.drawString(score, getWidth() - 100, 20);
			g.setFont(new Font(Font.DIALOG, Font.HANGING_BASELINE, 20));

			ArrayList<Player> playerList = players.getPlayers();

			for (int i = 0; i < playerList.size(); i++) {
				if (i >= 10)
					break;
				Player player = playerList.get(i);
				g.drawString(i + 1 + "", 55, 20 + 40 * (i + 1));
				g.drawString(player.getName(), getWidth() / 2 - 20, 20 + 40 * (i + 1));
				g.drawString(player.getScore() + "", getWidth() - 100, 20 + 40 * (i + 1));
			}
		}
	}
}
