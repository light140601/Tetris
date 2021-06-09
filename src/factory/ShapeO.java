package factory;

public class ShapeO extends Shape{

	public ShapeO(int x, int y, int size) {
		super(x, y, size);
		// TODO Auto-generated constructor stub
		this.create();
	}
	public ShapeO() {
		// TODO Auto-generated constructor stub
		this.create();
	}

	@Override 
	public void create(){
		int[][] temp = {{1,1},{1,1}};
		this.coords = temp;
	}
	

}
