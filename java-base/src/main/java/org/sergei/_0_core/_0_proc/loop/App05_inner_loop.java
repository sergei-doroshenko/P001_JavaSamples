package org.sergei._0_core._0_proc.loop;

/**
 * Created by Sergei on 21.02.2015.
 */
public class App05_inner_loop {
    public static void main (String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90};

        for (int k = 0; k < 4; k++) {
            for (int i = 3; i >= k; i--) {
                System.out.print(" " + i);
            }
            System.out.println();
        }




    }
}
