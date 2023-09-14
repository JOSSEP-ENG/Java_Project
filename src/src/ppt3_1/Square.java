package src.ppt3_1;

public class Square extends Shape {

	private double x;
	private double y;
	
	public Square(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public double calculateArea() {
		return x * y;
	}

}
