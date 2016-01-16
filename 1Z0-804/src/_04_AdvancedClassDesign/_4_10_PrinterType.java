package _04_AdvancedClassDesign;

/*------------------------------------------------------------------------------
 * Oracle Certified Professional Java SE 7 Programmer Exams 1Z0-804 and 1Z0-805: 
 * A Comprehensive OCPJP 7 Certification Guide
 * by SG Ganesh and Tushar Sharma
------------------------------------------------------------------------------*/
public enum _4_10_PrinterType {
	DOTMATRIX(5), INKJET(10), LASER(50);
	
	private int pagePrintCapacity;

	private _4_10_PrinterType(int pagePrintCapacity) {
		this.pagePrintCapacity = pagePrintCapacity;
	}	

	public int getPrintPageCapacity() {
		return pagePrintCapacity;
	}
}
