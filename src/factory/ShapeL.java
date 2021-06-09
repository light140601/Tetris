package factory;

public class ShapeL extends Shape {

	public ShapeL(int x, int y, int size) {
		super(x, y, size);
		// TODO Auto-generated constructor stub
		this.create();
	}

	public ShapeL() {
		// TODO Auto-generated constructor stub
		this.create();
	}

	@Override
	public void create() {
		int[][] temp = { { 1, 0 }, { 1, 0 }, { 1, 1 } };
		this.coords = temp;

	}

}
