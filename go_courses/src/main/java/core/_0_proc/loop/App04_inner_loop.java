package core._0_proc.loop;

/**
 * Created by Sergei on 21.02.2015.
 */
public class App04_inner_loop {
    public static void main (String[] args) {

        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < i; k++) {
                System.out.print(" " + k);
            }
            System.out.println();
        }

        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < 4; k++) {
                System.out.printf(" %.1S ", (i > k));
            }
            System.out.println();
        }

        for (int k = 0; k < 4; k++) {
            for (int i = 3; i >= 4 - k-1; i--) {
                System.out.print(" " + i);
            }
            System.out.println();
        }
        /*
         3
         3 2
         3 2 1
         3 2 1 0
         */


    }
}
