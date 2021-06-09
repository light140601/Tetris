package factory;

import java.awt.Color;
import java.awt.Graphics;

import model.IGame;

public abstract class Shape {
	protected Color color;
	protected int x;
	protected int y;
	protected int[][] coords;
	protected int size;
	protected int normalSpeed = 200;
	protected int downSpeed = 60;
	protected int currentSpeed;
	protected int detalX = 0;
	protected boolean collision = false;
	protected boolean moveX;
	protected IGame boarGame;

	public Shape(int x, int y, int size) {
		// TODO Auto-generated constructor stub
		this.currentSpeed = this.normalSpeed;
		this.x = 4;
		this.y = 0;

	}

	public Shape() {
		// TODO Auto-generated constructor stub
		this.currentSpeed = this.normalSpeed;
		this.x = 4;
		this.y = 0;
	}

	public abstract void create();

	// chuyển đổi
	public void rotate() {
		// insert code
		if (this.collision) {
			return;
		} else {
			int[][] temp = null;
			temp = this.transpose(coords);
			temp = this.reverse(temp);
			if(x + temp[0].length > 10 || y + temp.length > 20) {
				return;
			}
			for (int row = 0; row < temp.length; row++) {
				for (int col = 0; col < temp.length; col++) {
					if(this.boarGame.getBoard()[y+col][x+col] != 0) {
						return;
					}
				}
			}
			this.coords = temp;
		}

	}

	public void init() {
		// insert code
	}

	// main
	public void update() {
		// insert code
	}

	// vẽ mỗi cái 1 màu ??
	public void draw(Graphics g) {
		// insert code
	}
	// kieemr tra xong r bien mat
	public void check() {
		int height = this.boarGame.getBoard().length - 1;
		for (int i = height; i > 0; i--) {
			int count = 0;
			for (int j = 0; j < this.boarGame.getBoard()[0].length; j++) {
				if (this.boarGame.getBoard()[i][j] != 0) {
					count++;
				}
				this.boarGame.getBoard()[height][j] = this.boarGame.getBoard()[i][j];
			}
			if (count < this.boarGame.getBoard()[0].length) {
				height--;
			}
		}
	}

	public void left() {
		// insert code
		this.detalX = -1;
	}

	public void right() {
		// insert code
		this.detalX = 1;
	}

	// time++
	public void down() {
		// insert code
		this.normalSpeed++;
	}

	// đụng tường tình time của cai sau bình thường
	public void setNormalSpeed() {
		this.normalSpeed = 200;
	}

	// reverse
	public int[][] reverse(int[][] input) {
		int mid = input.length / 2;
		for (int i = 0; i < mid; i++) {
			int[] temp = input[i];
			input[i] = input[input.length - i - 1];
			input[input.length - i - 1] = temp;
		}
		return input;

	}

	// transpose
	public int[][] transpose(int[][] input) {
		int[][] output = new int[input[0].length][input.length];
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[0].length; j++) {
				output[j][i] = input[i][j];
			}
		}
		return output;

	}

	public int[][] getCoords() {
		return coords;
	}

	public int getDownSpeed() {
		return downSpeed;
	}

	public void setDownSpeed(int downSpeed) {
		this.downSpeed = downSpeed;
	}

	public int getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(int currentSpeed) {
		this.currentSpeed = currentSpeed;
	}

	public int getNormalSpeed() {
		return normalSpeed;
	}

}
