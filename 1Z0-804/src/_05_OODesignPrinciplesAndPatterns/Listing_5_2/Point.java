package _05_OODesignPrinciplesAndPatterns.Listing_5_2;

/*------------------------------------------------------------------------------
 * Oracle Certified Professional Java SE 7 Programmer Exams 1Z0-804 and 1Z0-805: 
 * A Comprehensive OCPJP 7 Certification Guide
 * by SG Ganesh and Tushar Sharma
------------------------------------------------------------------------------*/
// Point is an independent class and here we are using it with _6_19_Circle class
class Point {
	private int xPos;
	private int yPos;
	public Point(int x, int y) {
		xPos = x;
		yPos = y;
	}
	public String toString() {
		return "(" + xPos + "," + yPos + ")"; 
	}
}

