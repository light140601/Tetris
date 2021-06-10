package factory;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class ShapeT extends Shape {

	public ShapeT(int x, int y, int size) {
		super(x, y, size);
		// TODO Auto-generated constructor stub
		this.create();
		this.colorFlag = 5;
	}

	public ShapeT() {
		// TODO Auto-generated constructor stub
		this.create();
		this.colorFlag = 5;
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		int[][] temp = { { 1, 1, 1 }, { 0, 1, 0 } };
		this.coords = temp;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2f));
		g.setColor(color.CYAN);
		for (int row = 0; row < coords.length; row++) {
			for (int col = 0; col < coords[row].length; col++) {
				if (coords[row][col] != 0)
					g.drawRect(row * this.boarGame.getTileSize(), col * this.boarGame.getTileSize(),
							this.boarGame.getTileSize(), this.boarGame.getTileSize());

			}
		}
	}

}
