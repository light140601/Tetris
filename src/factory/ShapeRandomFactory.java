package factory;

import java.util.Random;

import model.IGame;

public class ShapeRandomFactory {

	public Shape creatShape(int size, IGame boardGame) {
		//insert code
		char result = this.creatShapeRandom();
		switch (result) {
		case 'J':
			return new ShapeJ(size, boardGame);
		case 'L':
			return new ShapeL(size, boardGame);
		case 'O':
			return new ShapeO(size, boardGame);
		case 'S':
			return new ShapeS(size, boardGame);
		case 'T':
			return new ShapeT(size, boardGame);
		case 'Z':
			return new ShapeZ(size, boardGame);
		default:
			return null;
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
