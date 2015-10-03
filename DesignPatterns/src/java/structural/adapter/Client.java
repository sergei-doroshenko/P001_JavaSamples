package structural.adapter;

import java.util.Arrays;

/**
 * Created by Sergei on 17.08.2015.
 */
public class Client {
    public static void main(String[] args) {
        Sorterer sorterer = new SortArrayAdapter();
        int[] arr0 = new int[] {10, 2, 36, -8};
        int[] arr1 = sorterer.sort(arr0);
        System.out.println(Arrays.toString(arr1));
    }
}
