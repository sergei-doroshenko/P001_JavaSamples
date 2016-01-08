package _06_GenericsAndCollections;

// This program shows the importance of equals() and hashCode() methods

public class _6_19_Circle {
	private int xPos, yPos, radius;
	public _6_19_Circle(int x, int y, int r) {
		xPos = x; 
		yPos = y;
		radius = r; 
	}
	
	public boolean equals(Object arg) {
		if(arg == null) return false; 
		if(this == arg) return true;
		if(arg instanceof _6_19_Circle) {
			_6_19_Circle that = (_6_19_Circle) arg;
			return (this.xPos == that.xPos) && (this.yPos == that.yPos) && (this.radius == that.radius );
		}
		return false;
	}
}
