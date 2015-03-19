package core._0_proc.loop;

import java.util.Arrays;

/**
 * Created by Sergei on 21.02.2015.
 */
public class App03_merge {
    public static void main (String[] args) {
        int[] arr1 = {20,40,50, 70, 80};
        int[] arr2 = {10,30, 60, 90, 100, 120, 130, 140};

        goMerge(arr1, arr2);
        goMerge(new int[]{}, new int[0]);
        goMerge(new int[0], new int[]{10});
        goMerge(new int[0], new int[]{10, 20, 30});
        goMerge(new int[]{10,20,30}, new int[0]);
        goMerge(new int[]{10,20,30}, new int[]{10, 20, 30});
        goMerge(new int[]{10,20,30}, new int[]{40, 50, 60});
        goMerge(new int[]{10,20,40,70}, new int[]{30,50,60,80,90,100});
    }

    public static void goMerge(int[]a, int[]b) {
        System.out.println(Arrays.toString(merge(a, b)));
    }

    public static int[] merge (int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int left = 0;
        int right = 0;
        int res = 0;
        while (left + right < result.length) {
            if (left == a.length) {
                //result[left + right] = b[right++]; // slow implementation
                System.arraycopy(b, right, result, left+right, b.length - right);
                right = b.length;
            } else if (right == b.length) {
                //result[left + right] = a[left++];
                System.arraycopy(a, left, result, left+right, a.length - left);
                left = a.length;
            } else {
                if (a[left] < b[right]) {
                    result[left + right] = a[left++];
                } else {
                    result[left + right] = b[right++];
                }
            }


        }

        return result;
    }
}
