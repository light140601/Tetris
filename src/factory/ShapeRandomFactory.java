package factory;

import java.util.Random;

import model.IGame;

public class ShapeRandomFactory {

	public Shape creatShape(int x, int y, int size) {
		//insert code
		char result = this.creatShapeRandom();
		switch (result) {
		case 'J':
			return new ShapeJ();
		case 'L':
			return new ShapeL();
		case 'O':
			return new ShapeO();
		case 'S':
			return new ShapeS();
		case 'T':
			return new ShapeT();
		case 'Z':
			return new ShapeZ();

		default:
			break;
		}
		return null;
		
	}
	public char creatShapeRandom() {
		//insert code
		char[] icons = {'J', 'L', 'O', 'S', 'T', 'Z'};
		Random r = new Random();
		int index = r.nextInt(icons.length);
		return icons[index];
	}
	public static void main(String[] args) {
		
	}
}
