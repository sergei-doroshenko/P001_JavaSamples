package org.sergei._0_core._9_bits;

/**
 * Created by Sergei on 20.03.2015.
 */
public class App03 {
    public static void main(String[] args) {
        System.out.println(0b1001_1100); // 156

        int a = 7 + (~2);
        int b = 7 - 3;
        System.out.println(a);
        System.out.println(b);
        System.out.println(Integer.toBinaryString(3));

        System.out.println(true ^ false);

        String s = null;
        System.out.println(s != null && s.length() > 10);

        System.out.println(20/2/5);




    }
}
