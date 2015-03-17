package _8_exceptions;

/**
 * Created by Sergei on 04.03.2015.
 */
public class App02 {
    public static void main(String args[]) {

        try {
            methodX();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void methodX() throws Exception {

        throw new AssertionError();
    }
}

// Exception in thread "main" java.lang.AssertionError
