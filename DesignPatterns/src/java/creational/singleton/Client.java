package creational.singleton;

/**
 * Created by Sergei on 17.08.2015.
 */
public class Client {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Log message");
    }
}
