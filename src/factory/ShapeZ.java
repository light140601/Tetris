package factory;

public class ShapeZ extends Shape{

	public ShapeZ(int x, int y, int size) {
		super(x, y, size);
		// TODO Auto-generated constructor stub
		this.create();
	}
public ShapeZ() {
	// TODO Auto-generated constructor stub
	this.create();
}
	@Override
	public void create() {
		// TODO Auto-generated method stub
		int[][] temp = {{1,1,0},{0,1,1}};
		this.coords = temp;
	}

}
