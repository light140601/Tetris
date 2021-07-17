package view.language;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import translation.Translation;
import controller.Controller;
import controller.IController;
import model.Game;
import view.pause.IPause;

public class LanguageScreen extends JDialog implements ILanguage, MouseListener {

	private IController controller;
	private JLabel title;
	private JButton english, vietnamese, chinese, cancleBt;
	private JPanel btnPn;
	private boolean show;

	public LanguageScreen(IController controller) {
		this.controller = controller;
		this.getContentPane().setBackground(new Color(189, 215, 255));
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

		add(title = new JLabel());
		title.setPreferredSize(new Dimension(180, 50));
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
		add(english = setUpBtn("ENGLISH"));
		add(vietnamese = setUpBtn("VIETNAMESE"));
		add(chinese = setUpBtn("CHINESE"));

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		// cancle button
		add(btnPn = new JPanel());
		btnPn.setBackground(new Color(189, 215, 255));
		btnPn.setPreferredSize(new Dimension(115, 50));
		btnPn.setLayout(new FlowLayout(FlowLayout.RIGHT));
		btnPn.add(cancleBt = new JButton("CANCLE"));
		cancleBt.setPreferredSize(new Dimension(100, 30));
		cancleBt.setBackground(new Color(240, 205, 139));
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
		
		
		setSize(280, 350);
		setTitle("Language");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

	private JButton setUpBtn(String value) {
		JButton btn = new JButton(value);
		btn.setPreferredSize(new Dimension(150, 35));
		btn.setBackground(new Color(240, 205, 139));
		btn.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn.addMouseListener(this);
		return btn;
	}

	@Override
	public void dispose() {
		super.dispose();
		show = false;
	}

	@Override
	public void show() {
		super.show();
		show = true;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (english == e.getSource())
			translateEnglish();
		if (vietnamese == e.getSource()) {
			translateVietnamese();
		}
		if (chinese == e.getSource())
			translateChinese();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (english == e.getSource())
			english.setBackground(new Color(240, 177, 60));
		if (vietnamese == e.getSource())
			vietnamese.setBackground(new Color(240, 177, 60));
		if (chinese == e.getSource())
			chinese.setBackground(new Color(240, 177, 60));
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (english == e.getSource())
			english.setBackground(new Color(240, 205, 139));
		if (vietnamese == e.getSource())
			vietnamese.setBackground(new Color(240, 205, 139));
		if (chinese == e.getSource())
			chinese.setBackground(new Color(240, 205, 139));
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void translateEnglish() {
		this.setTitle("LANGUAGE");
		title.setText("LANGUAGE");
		english.setText("ENGLISH");
		vietnamese.setText("VIETNAMESE");
		chinese.setText("CHINESE");
		cancleBt.setText("CANCLE");
		
		controller.tranlateEnglish();
	}

	@Override
	public void translateVietnamese() {
		this.setTitle("NGÔN NGỮ");
		title.setText("NGÔN NGỮ");
		english.setText("TIẾNG ANH");
		vietnamese.setText("TIẾNG VIỆT");
		chinese.setText("TIẾNG TRUNG");
		cancleBt.setText("HỦY");

		controller.tranlateVietnamese();
		
	}

	@Override
	public void translateChinese() {
		this.setTitle("語");
		title.setText("語");
		english.setText("英語");
		vietnamese.setText("越南人");
		chinese.setText("中國人");
		cancleBt.setText("取消");

		controller.tranlateChinese();
	}


	
}
