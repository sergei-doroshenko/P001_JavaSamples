package core._0_proc.mem._0_by_ref_by_val;

import java.util.Arrays;

/**
 * Created by Sergei on 25.02.2015.
 */
public class App00 {
    public static void main(String[] args) {
        int x = 0;
        int y = x;
        x = 1;
        System.out.println("x: " + x); // print 1
        System.out.println("y: " + y); // print 0

        int[] a1 = {1, 2, 3};
        int[] a2 = a1;
        a1[0] = 10;
        System.out.println(Arrays.toString(a2)); // [10, 2, 3]
        a1 = null;
        System.out.println(Arrays.toString(a2)); // [10, 2, 3]
    }
}
