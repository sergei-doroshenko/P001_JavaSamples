package _1_java_basics;

/**
 * Created by Sergei on 23.03.2015.
 */
public class App03_char {
    public static void main(String[] args) {
        String str = 'b' + "a";
        System.out.println(str); // ba
        System.out.println(3 + 'c'); // 102
        System.out.println('a' + 1); // 98
        final int i0 = 10;
        byte b0 = i0; // if i0 will be not final, we should use explicit cast to byte
    }
}
