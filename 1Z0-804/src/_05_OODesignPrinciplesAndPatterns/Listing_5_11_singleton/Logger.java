package _05_OODesignPrinciplesAndPatterns.Listing_5_11_singleton;

/*------------------------------------------------------------------------------
 * Oracle Certified Professional Java SE 7 Programmer Exams 1Z0-804 and 1Z0-805: 
 * A Comprehensive OCPJP 7 Certification Guide
 * by SG Ganesh and Tushar Sharma
------------------------------------------------------------------------------*/
public class Logger {

	// private constructor
	private Logger() {
		System.err.println("Logger class private constructor called.");
	}

	// nested class
	public static class LoggerHolder {
		static {
			System.err.println("LoggerHolder class init.");
		}
		// static field to hold outer class instance
		public static Logger logger = new Logger();

	}

	public static Logger getInstance() {
		// Dynamic class loading
		// JVM init LoggerHolder class when needed, when first call to class appears.
		return LoggerHolder.logger;
	}

	public void log(String s) {
		// log implementation
		System.err.println(s);
	}

	public static void main(String[] args) {
		Logger logger = Logger.getInstance();
		logger.log("Log message");
	}
}