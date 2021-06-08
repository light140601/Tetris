package factory;

import java.util.Random;

import model.IGame;

public class ShapeRandomFactory {

	public Shape creatShape(char type, int size, IGame boardGame) {
		//insert code
		char result = this.creatShapeRandom();
		switch (result) {
		case 'J':
			return new ShapeJ();
			break;
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
		
	}
	public char creatShapeRandom() {
		//insert code
		char[] icons = {'J', 'L', 'O', 'S', 'T', 'Z'};
		Random r = new Random();
		int index = r.nextInt(icons.length);
		return icons[index];
	}
}
