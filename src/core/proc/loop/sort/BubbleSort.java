package core.proc.loop.sort;


import java.util.Arrays;

/**
 * Created by Sergei on 22.02.2015.
 */
public class BubbleSort {
    public static void main (String[] args) {
        int[] arr = {7, 10, 15, 8, 30};

        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {

        for(int outRight = arr.length-1, in = 0; outRight > 0; outRight--) {  // outer loop (backward)
            if (in < outRight) {
                for (; in < outRight; in++) {      // inner loop (forward)
                    if (arr[in] > arr[in + 1]) {    // out of order?
                        swap(arr, in, in + 1);      // swap them
                    }
                }
            } else {
                for (; in > 0; in--) {      // inner loop (backward)
                    if (arr[in] < arr[in - 1]) {
                        swap(arr, in, in - 1);          // swap them
                    }
                }
            }
        }
    }

    public static void swap(int[] arr, int one, int two) {
        int temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }
}
