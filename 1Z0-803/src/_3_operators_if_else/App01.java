package _3_operators_if_else;

/**
 * Created by Sergei on 02.03.2015.
 */
public class App01 {
    public static void main(String[] args) {
        System.out.println('b' + new Integer(63)); // 161

        byte b0 = 3;
        byte b1 = 4;
        byte b2 = (byte) (b0 + b1);

        int i = 1234567890;
        float f = i; // 1.23456794E9
        System.out.println(i - (int)f); // -46
    }
}
