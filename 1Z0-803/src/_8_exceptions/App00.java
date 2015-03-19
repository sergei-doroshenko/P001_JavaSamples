package _8_exceptions;

/**
 * Created by Sergei on 04.03.2015.
 */
public class App00 {
    public static void main(String args[]) throws Exception {

        methodX();

        Exception e = null;
        throw e;

    }

    public static void methodX() throws Exception {

        throw new AssertionError();
    }
}
