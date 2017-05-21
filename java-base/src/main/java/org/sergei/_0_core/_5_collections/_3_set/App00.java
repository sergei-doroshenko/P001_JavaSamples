package org.sergei._0_core._5_collections._3_set;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sergei on 05.05.2015.
 */
public class App00 {
    public static void main(String[] args) {
        Set<Product> set0 = new HashSet<>();
        Product p0 = new Product(0, "apple");
        Product p1 = new Product(1, "lemon");
        set0.add(p0);
        set0.add(p1);
        System.out.println(set0);
        Product p2 = new Product(1, "banana");
        set0.add(p2);
        /*
        if set already contains adding object it doesn't insert it,
        but map replace.
         */
        System.out.println(set0);
    }

}
