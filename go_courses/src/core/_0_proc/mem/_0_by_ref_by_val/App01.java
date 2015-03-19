package core._0_proc.mem._0_by_ref_by_val;

import java.util.Arrays;

/**
 * Created by Sergei on 25.02.2015.
 */
public class App01 {
    static int x = 100;
    public static void main(String[] args) {
        //int x = 0;

        f(x);

        System.out.println("x: " + x); // print 0

        int[] a = {0, 1, 2};

        g(a);
        System.out.println("a: " + Arrays.toString(a));
        k(a);
        System.out.println("a: " + Arrays.toString(a));
    }

    // primitives passes by value
    public static void f(int x) {
        x++;
    } // we have static field x, but it doesn't matter

    // ref passes into method by it's value (copy address)
    // objects passes by reference
    private static void g(int[] a) {
        a[0] = 1; // change array by link
        a = null; // null ref from method arguments
    }

    private static void k(int[] a) {
        a = new int[] {1};
    }







}
