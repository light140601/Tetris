package factory;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class ShapeO extends Shape{

	public ShapeO(int x, int y, int size) {
		super(x, y, size);
		// TODO Auto-generated constructor stub
		this.create();
		this.colorFlag = 3;
	}
	public ShapeO() {
		// TODO Auto-generated constructor stub
		this.create();
		this.colorFlag = 3;
	}

	@Override 
	public void create(){
		int[][] temp = {{1,1},{1,1}};
		this.coords = temp;
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2f));
		g.setColor(color.BLUE);
		for (int row = 0; row < coords.length; row++) {
			for (int col = 0; col < coords[row].length; col++) {
				if (coords[row][col] != 0)
					g.drawRect(row * this.boarGame.getTileSize(), col * this.boarGame.getTileSize(),
							this.boarGame.getTileSize(), this.boarGame.getTileSize());

			}
		}
	}
	

}
