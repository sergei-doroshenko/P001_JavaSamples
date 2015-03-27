package _4_arrays;

import java.util.Arrays;

/**
 * Created by Sergei on 04.03.2015.
 */
public class App01 {
    /*private static int[] arr;*/
    public static int[] getArray() {
        /*arr = new int[3];*/
        return null /*arr*/;
    }

    public static void main(String[] args) {
        int index = 1;

        try {
            getArray()[index = 2]++;
        } catch (Exception e) {
            //empty catch
        }

        System.out.println("index = " + index); // index = 2
        /*System.out.println(Arrays.toString(arr));*/ // [0, 0, 1]
    }
}