package core._11_memory_overflow;

/**
 * Created by Sergei on 05.10.2015.
 * The result of run this code snippet is
 * Exception in thread "main" java.lang.StackOverflowError
 */
public class App00_stack {
    public static void main(String[] args) {
        System.out.println(method(10));
    }

    public static int method(int i) {
        System.out.println(i++);
        return method(i);
    }
}
