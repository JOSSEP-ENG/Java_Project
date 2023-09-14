package src.ppt3_1;

public class Circle extends Shape {

	public Circle(double radius) {
		this.radius = radius;
	}
	
	@Override
	public double calculateArea() {		
		return Math.PI * radius * radius;
	}
	
	private double radius;

}
