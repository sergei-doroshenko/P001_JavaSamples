package org.sergei._0_core._1_excep;

/**
 * Created by Sergei on 25.02.2015.
 */
public class App00 {
    public static void main(String[] args) {
        System.out.println(area(-10, 20));
    }

    public static int area(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("a < 0 || b < 0 == true, a = " + a + ", b = " + b);
        }
        return a * b;
    }
}
