package factory;

public class ShapeT extends Shape{

	public ShapeT(int x, int y, int size) {
		super(x, y, size);
		// TODO Auto-generated constructor stub
		this.create();
	}
public ShapeT() {
	// TODO Auto-generated constructor stub
	this.create();
}
	@Override
	public void create() {
		// TODO Auto-generated method stub
		int[][] temp = {{1,1,1},{0,1,0}};
		this.coords = temp;
	}

}
