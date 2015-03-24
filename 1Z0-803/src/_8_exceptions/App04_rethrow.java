package _8_exceptions;

/**
 * Created by Sergei on 24.03.2015.
 */
public class App04_rethrow {
    public static void main(String[] args) throws MyException {
        f();
    }

    public static void f() throws MyException {
        try {
            throw new MyException();
        } catch (Exception e) {
            System.err.println("MyException in f()");
            throw e;
        }
    }

}

class MyException extends Exception {}