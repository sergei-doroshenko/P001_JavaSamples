package creational.singleton;

/**
 * Created by Sergei on 17.08.2015.
 */
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
        System.err.println("Logger getInstance called.");
        // Dynamic class loading
        // JVM init LoggerHolder class when needed, when first call to class appears.
        return LoggerHolder.logger;
    }

    public void log(String s) {
        // log implementation
        System.err.println(s);
    }
}
