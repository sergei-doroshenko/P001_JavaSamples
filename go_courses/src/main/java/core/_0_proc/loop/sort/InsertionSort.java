package core._0_proc.loop.sort;


import java.util.Arrays;

/**
 * Created by Sergei on 22.02.2015.
 */
public class InsertionSort {
    public static void main (String[] args) {
        int[] arr = {7, 10, 0, 47, 15, 8, 30, 0};

        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {

        for(int out = 1; out < arr.length; out++) {
            int temp = arr[out];       // out is dividing line
            int in = out;              // start shifting at out

            while(in > 0 && arr[in - 1] > temp) { // until smaller one found,
                arr[in] = arr[in - 1];            // shift item to the right
                --in;                             // go left one position
            }

            arr[in] = temp;               // insert marked item
        }  // end for
    }
}
