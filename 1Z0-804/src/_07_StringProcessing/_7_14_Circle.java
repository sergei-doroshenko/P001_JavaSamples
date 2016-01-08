package _07_StringProcessing;

// This program shows the usage of formatting string in printf() method
public class _7_14_Circle {
	private int x, y, radius;
	public _7_14_Circle(int x, int y, int radius) {
		this.x =x;
		this.y = y;
		this.radius = radius;
	}
	void area() {
		double tempArea = Math.PI * radius * radius;  
		System.out.println("Cirle area using default formatting with println: " + tempArea);
		System.out.printf("_6_19_Circle area using format specifier with printf: %.2f",  tempArea);
	}
	public static void main(String[] str) {
		_7_14_Circle circle = new _7_14_Circle(10,10,5);
		circle.area();
	}
}