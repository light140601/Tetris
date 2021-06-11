package factory;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

import model.IGame;

public class ShapeS extends Shape {

	public ShapeS(int size, IGame boarGame) {
		super(size, boarGame);
		this.coords = new int[][] { { 0, 1, 1 }, { 1, 1, 0 } };
		this.colorFlag = 4;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2f));
		g.setColor(color.RED);
		for (int row = 0; row < coords.length; row++) {
			for (int col = 0; col < coords[row].length; col++) {
				if (coords[row][col] != 0)
					g.drawRect(row * this.boarGame.getTileSize(), col * this.boarGame.getTileSize(),
							this.boarGame.getTileSize(), this.boarGame.getTileSize());

			}
		}
	}

}
