package _1_java_basics;

/**
 * Created by Sergei on 26.03.2015.
 */
public class App06_byte {
    public static void main(String[] args) {
        byte b0 = 68;
        System.out.println(Integer.toBinaryString(b0)); // 1000100
        char c0 = 'D'; // 'D' code point = 68
        System.out.println(Integer.toBinaryString(c0)); // 1000100

        b0 = (byte) c0; // b0 = c0 -> compilation error
        c0 = (char) b0; // c0 = b0 -> compilation error

        b0 = 'D';

        byte b1 = -128;
        int i0 = b1;
        System.out.println(i0); // -128
    }
}
