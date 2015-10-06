package core._0_proc.loop;

import java.util.Arrays;

/**
 * Created by Sergei on 21.02.2015.
 */
public class App02 {
    public static void main (String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        //int[] arr = new int[0];
        System.out.println(Arrays.toString(arr));
        // 0 .. --> .. 50
        /*for (int i = 0; i < arr.length/2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1  - i];
            arr[arr.length - 1  - i] = temp;

        }*/
        // 0 .. <-- 30 .. 50

        for (int i = arr.length/2; i > 0; i--) {
            int temp = arr[i-1]; // 0
            arr[i-1] = arr[arr.length - i];
            arr[arr.length - i] = temp;
        }
        /*
        Test cases:
        int[] arr = {}; -> []
        int[] arr = {10}; -> [10]
        int[] arr = {10, 20}; -> [20, 10]
        int[] arr = {10, 20, 30}; -> [30, 20, 10]
        int[] arr = {10, 20, 30, 40}; -> [40, 30, 20, 10]
        int[] arr = {10, 20, 30, 40, 50, 60}; -> [60, 50, 40, 30, 20, 10]
        int[] arr = {10, 20, 30, 40, 50, 60, 70}; -> [70, 60, 50, 40, 30, 20, 10]
         */
        System.out.println(Arrays.toString(arr));

    }
}
