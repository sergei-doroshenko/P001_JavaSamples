package core._7_arrays;

import java.util.Arrays;

/**
 * Created by Sergei Doroshenko on 20.03.2015.
 *
 * Examples of array declaration and initialization
 */
public class App00 {
    public static void main(String[] args) {
        int[] a0 = {1, 2, 3};

        int[] a1 = {}; // []
        System.out.println(Arrays.toString(a1));

        int[] a2;
        a2 = new int[] {1, 2, 3};

        int[] a3[] = { {1,2}, {3,4}, {}, {5,6} };

        int[] a4[] = { {1,2}, new int[]{3,4}, {}, new int[5] };

        int[][] a5 = new int[2][]; // last may be empty
        System.out.println(Arrays.deepToString(a5));

        int[] a6 = new int[4]; // [0, 0, 0, 0]
        System.out.println(Arrays.toString(a6));

        int[] a7[] = {{}}; // [[]]
        System.out.println(Arrays.deepToString(a7));
    }
}
