package factory;

public class ShapeS extends Shape {

	public ShapeS(int x, int y, int size) {
		super(x, y, size);
		// TODO Auto-generated constructor stub
		this.create();
	}

	public ShapeS() {
		// TODO Auto-generated constructor stub
		this.create();
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		int[][] temp = { { 0, 1, 1 }, { 1, 1, 0 } };
		this.coords = temp;
	}

}
