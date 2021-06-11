package factory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import model.IGame;

public abstract class Shape {
	protected Color color;
	protected int colorFlag;
	protected int x;
	protected int y;
	protected int[][] coords;
	protected int size;
	protected int normalSpeed = 600;
	protected int downSpeed = 60;
	protected int currentSpeed;
	protected int detalX = 0;
	protected boolean collision = false;
	protected boolean moveX;
	protected IGame boarGame;
	protected long time, lastTime;

	public Shape(int size, IGame boarGame) {
		this.size = size;
		this.boarGame = boarGame;
		currentSpeed = normalSpeed;
		x = 4;
		y = 0;
		time = 0;
		lastTime = 0;
	}

	public abstract void draw(Graphics g);

	// main
	public void update() {
		// insert code
		time += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		if (collision) {
			for (int row = 0; row < coords.length; row++) {
				for (int col = 0; col < coords[row].length; col++) {
					if (coords[row][col] != 0) {
						this.boarGame.getBoard()[y + row][x + col] = colorFlag;
					}
				}
			}
			boarGame.setCurrentShape();
			boarGame.checkLine();
		}
		if (!(x + this.detalX + coords[0].length > 10) && !(x + this.detalX < 0)) {
			for (int row = 0; row < coords.length; row++) {
				for (int col = 0; col < coords[row].length; col++) {
					if (coords[row][col] != 0) {
						if (this.boarGame.getBoard()[y + row][x + this.detalX + col] != 0) {
							this.moveX = false;
						}
					}
				}
			}
			if (moveX) {
				x += this.detalX;
			}
		}
		// full y
		if (!(y + 1 + coords.length > 20)) {
			for (int row = 0; row < coords.length; row++) {
				for (int col = 0; col < coords[row].length; col++) {
					if (coords[row][col] != 0) {
						if (this.boarGame.getBoard()[y + row + 1][col + x] != 0) {
							collision = true;
						}
					}
				}
			}
			if (time > currentSpeed) {
				y++;
				time = 0;
			}
		} else {
			collision = true;
		}

		this.detalX = 0;
		moveX = true;
	}

	//xoay
	public void rotate() {
		// insert code
		if (this.collision) {
			return;
		} else {
			int[][] temp = null;
			temp = this.transpose(coords);
			temp = this.reverse(temp);
			if (x + temp[0].length > 10 || y + temp.length > 20) {
				return;
			}
			for (int row = 0; row < temp.length; row++) {
				for (int col = 0; col < temp.length; col++) {
					if (this.boarGame.getBoard()[y + col][x + col] != 0) {
						return;
					}
				}
			}
			this.coords = temp;
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
		currentSpeed = downSpeed;
	}

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
