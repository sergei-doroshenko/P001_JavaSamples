package _1_java_basics;

/**
 * Created by Sergei on 23.03.2015.
 */
public class App03 {
    public static void main(String[] args) {
        String str = 'b' + "a";
        System.out.println(str);
        final int i0 = 10;
        byte b0 = i0; // if i0 will be not final, we should use explicit cast to byte
    }
}
