package src.ppt3_1;

public class MainClass {

	public static void main(String[] args) {
		
		Shape circle = new Circle(2.0);
		Shape square = new Square(3,4);
		Shape tri = new Triangle(3,4);		
		
		figure(circle);
		figure(square);
		figure(tri);
	}
	
	public static void figure(Shape any) {
		System.out.println(any.calculateArea());
	}

}
