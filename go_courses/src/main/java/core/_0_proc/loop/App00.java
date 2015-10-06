package core._0_proc.loop;

import java.util.Arrays;

/**
 * Created by Sergei on 21.02.2015.
 */
public class App00 {
    public static void main (String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        System.out.println(arr); // -> [I@1ef9157 [ - array, I - int, @ + hashCode
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + ":" + arr[i]);
        }
        int i = 7;
        int k = i++ + ++i;
        System.out.println(k); // 16
        System.out.println(i); // 9

    }
}
