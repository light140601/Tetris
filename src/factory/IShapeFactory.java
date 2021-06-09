package factory;

import model.IGame;

public interface IShapeFactory {
	public Shape creatShape(int x, int y, int size);
}
