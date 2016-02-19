package _3_methods;

/**
 * Created by sergei on 2/19/16.
 */
public class StaticNull {
    public static String hello() {
        return "hello";
    }

    public static void main(String[] args) {
        StaticNull staticNull = null;
        System.out.println(staticNull.hello());
    }
}
