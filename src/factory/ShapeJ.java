package factory;

public class ShapeJ extends Shape{

	public ShapeJ(int x, int y, int size) {
		super(x, y, size);
		// TODO Auto-generated constructor stub
		this.create();
	}
	public ShapeJ() {
		// TODO Auto-generated constructor stub
		this.create();
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		int[][] temp = {{0,1},{0,1},{1,1}};
		this.coords = temp;
	}

}
