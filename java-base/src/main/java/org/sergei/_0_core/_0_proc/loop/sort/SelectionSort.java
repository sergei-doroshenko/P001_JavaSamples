package org.sergei._0_core._0_proc.loop.sort;


import java.util.Arrays;

/**
 * Created by Sergei on 22.02.2015.
 */
public class SelectionSort {
    public static void main (String[] args) {
        int[] arr = {7, 10, 0, 15, 8, 30, 0};

        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {

        int min;

        for(int out = 0; out < arr.length - 1; out++) {  // outer loop

            min = out;                        // set minimum
            /* inner loop to find minimum in range out+1..arr.length (e.g. 0..6) */
            for(int in = out + 1; in < arr.length; in++) {

                if (arr[in] < arr[min]) {   // if min greater,
                    min = in;               // we have a new min
                }
            }

            swap(arr, out, min);                // swap them (e.g. 0 and min etc)
        }  // end for(out)
    }

    public static void swap(int[] arr, int one, int two) {
        int temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }
}
