package _05_OODesignPrinciplesAndPatterns.Listing_5_12;/*------------------------------------------------------------------------------
 * Oracle Certified Professional Java SE 7 Programmer Exams 1Z0-804 and 1Z0-805: 
 * A Comprehensive OCPJP 7 Certification Guide
 * by SG Ganesh and Tushar Sharma
------------------------------------------------------------------------------*/

public class Test {
	public static void main(String[] args) {
		Canvas canvas = new Canvas();
		canvas.addNewShape("_6_19_Circle");
		canvas.addNewShape("Rectangle");
		canvas.redraw();
	}
}
