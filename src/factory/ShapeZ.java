package factory;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

import model.IGame;

public class ShapeZ extends Shape {

	public ShapeZ(int size, IGame boarGame) {
		super(size, boarGame);
		// TODO Auto-generated constructor stub
		this.coords = new int[][] { { 1, 1, 0 }, { 0, 1, 1 } };
		this.colorFlag = 6;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2f));
		for (int row = 0; row < coords.length; row++) {
			for (int col = 0; col < coords[row].length; col++) {
				if (coords[row][col] != 0)
					g.drawRect(row * this.boarGame.getTileSize(), col * this.boarGame.getTileSize(),
							this.boarGame.getTileSize(), this.boarGame.getTileSize());

			}
		}
	}

}
