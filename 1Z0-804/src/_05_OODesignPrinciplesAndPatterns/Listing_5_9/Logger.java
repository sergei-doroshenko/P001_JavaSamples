package _05_OODesignPrinciplesAndPatterns.Listing_5_9;

/*------------------------------------------------------------------------------
 * Oracle Certified Professional Java SE 7 Programmer Exams 1Z0-804 and 1Z0-805: 
 * A Comprehensive OCPJP 7 Certification Guide
 * by SG Ganesh and Tushar Sharma
------------------------------------------------------------------------------*/
public class Logger {
	private Logger() {
		// private constructor
	}
	private static Logger myInstance;
	public static Logger getInstance() {
		if(myInstance == null) {
			synchronized (Logger.class) {
				myInstance = new Logger();
			}
		}			
		return myInstance;
	}
	public void log(String s) {
		// log implementation
		System.err.println(s);
	}
}
