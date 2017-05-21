package org.sergei._0_core._0_proc.loop;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sergei on 21.02.2015.
 */
public class App01 {
    public static void main (String[] args) {
        int a = 2;
        int b = 3;
        System.out.println("a=" + a + "; b=" + b);
        /*int tmp = a;
        a = b;
        b = tmp;*/
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a=" + a + "; b=" + b);

        System.out.println(1.0 / 0); // Infinity
        System.out.println(0.0 / 0); // NaN

        double x = Double.parseDouble("Infinity");
        System.out.println(x);

        Set<String> set = new HashSet<>();
        set.hashCode();

    }
}
