package _05_OODesignPrinciplesAndPatterns.Listing_5_12;/*------------------------------------------------------------------------------
 * Oracle Certified Professional Java SE 7 Programmer Exams 1Z0-804 and 1Z0-805: 
 * A Comprehensive OCPJP 7 Certification Guide
 * by SG Ganesh and Tushar Sharma
------------------------------------------------------------------------------*/

public class Circle implements Shape {
	private int xPos, yPos;
	private int radius;
	public Circle(int x, int y, int r) {
		xPos = x;
		yPos = y;
        		radius = r;
        		System.out.println("_6_19_Circle constructor");
        	}
	@Override
	public void draw() {
		System.out.println("_6_19_Circle draw()");
		// draw() implementation
	}
	@Override
	public void fillColor() {
		// fillColor() implementation
	}
}
