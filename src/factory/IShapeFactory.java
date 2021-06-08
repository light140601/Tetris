package factory;

import model.IGame;

public interface IShapeFactory {
	public Shape creatShape(char type, int size, IGame boardGame);
}
