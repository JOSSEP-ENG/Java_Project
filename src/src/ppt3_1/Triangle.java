package src.ppt3_1;

public class Triangle extends Shape {

	private double width;
	private double height;
	
	public Triangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	public double calculateArea() {		
		return (width*height)/2;
	}

}
