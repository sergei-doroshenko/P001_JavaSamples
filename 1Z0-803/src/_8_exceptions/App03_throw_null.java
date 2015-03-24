package _8_exceptions;

/**
 * Created by Sergei on 24.03.2015.
 */
public class App03_throw_null {
    public static void main(String[] args) throws Exception {
        Exception e = null;
        throw e; // NullPointerException
    }
}
