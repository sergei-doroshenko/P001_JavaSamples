package org.sergei._0_core._5_collections;

import java.util.*;

/**
 * Created by Sergei on 12.03.2015.
 */
public class App02 {
    public static void main(String[] args) {
        Map<String, Integer> map0 = new HashMap<>();
        map0.put("A", 1);
        map0.put("BB", 10);
        map0.put("CCC", 100);
        map0.put("BB", 1000);
        System.out.println(map0);

        Map<String, List<Integer>> map1 = new HashMap<>();
        map1.put("A", Arrays.asList(1, 2, 3));
        map1.put("B", Arrays.asList(10, 200, 30));
        map1.put("C", Arrays.asList(50, 60, 300));
        System.out.println(map1);

        for(Map.Entry e : map1.entrySet()) {
            System.out.println(e);
        }

        for (Iterator it = map1.entrySet().iterator(); it.hasNext();) { // if NO - java.util.NoSuchElementException

            System.out.println(it.next());
        }
    }
}
