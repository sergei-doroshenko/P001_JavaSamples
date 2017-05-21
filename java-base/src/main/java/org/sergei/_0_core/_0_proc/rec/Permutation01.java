package org.sergei._0_core._0_proc.rec;

import java.util.Arrays;

/**
 * Created by Sergei on 23.02.2015.
 */
public class Permutation01 {
    public static void main (String[] args) {
        String[] arr = {"A", "B", "C", "D"};
        permutation(arr, arr.length);
        /*shiftLeft(arr, 2);
        shiftLeft(arr, 2);

        System.out.println(Arrays.toString(arr));*/
    }

    public static void permutation(String[] arr, int size){

        if (size < 2) {
            System.out.println(Arrays.toString(arr));
        } else {

            for (int k = 0; k < size; k++) {

                /*if (size == 3) {
                    System.out.println("---------------------------------");
                    System.out.println(k);
                    System.out.println(Arrays.toString(arr));
                    System.out.println("---------------------------------");

                }*/

                permutation(arr, size - 1);

                //swap(arr, k, size - 1);
                shiftLeft(arr, size);

            }

        }
    }

    public static void shiftLeft(String[] arr, int size) {
        String temp = arr[0];
        for (int i = 0; i < size-1; i++) {
            arr[i] = arr[i+1];
        }
        arr[size-1] = temp;
    }

    public static void swap(int[] arr, int one, int two) {
        int temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }
}
