package _8_exceptions;

/**
 * Created by Sergei on 29.03.2015.
 */
public class App05_ClassNotFound {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = classLoader.loadClass("hello"); // ClassNotFoundException: hello
    }

}
