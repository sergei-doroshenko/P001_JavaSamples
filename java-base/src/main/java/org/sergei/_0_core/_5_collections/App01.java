package org.sergei._0_core._5_collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
//import static java.lang.*;
import static java.lang.System.out;
/**
 * Created by Sergei on 11.03.2015.
 */
public class App01 {
    public static void main(String[] args) {
        Set<String> set_0 = new HashSet<>();
        out.println(set_0.add("A"));
        System.out.println(set_0.add("B"));
        System.out.println(set_0.add("C"));
        System.out.println(set_0.add("B"));
        System.out.println(set_0);
        System.out.println(set_0.contains("C"));

        Set<String> set_1 = new HashSet<>(Arrays.asList("X", "Y", "Z", "X", "Y"));
        System.out.println(set_1);

        for (Iterator iter = set_1.iterator(); iter.hasNext();) {
            System.out.println(iter.next());
        }

        for (String elem : set_0) {
            if (elem.startsWith("B")) {
                // set_0.remove(elem); // ConcurrentModificationException
            }
        }
    }
}
