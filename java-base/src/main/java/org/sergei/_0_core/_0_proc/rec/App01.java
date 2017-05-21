package org.sergei._0_core._0_proc.rec;

/**
 * Created by Sergei on 22.02.2015.
 */
public class App01 {
    public static void main (String[] args) {
        f(1);
    }

    public static void f (int k) {
        long l1 = 0;
        long l2 = 0;
        long l3 = 0;
        long l4 = 0;
        long l5 = 0;
        long l6 = 0;
        System.out.println(" " + k);
        f(1 + k);


    }
    /* result 4572 and java.lang.StackOverflowError */
}
