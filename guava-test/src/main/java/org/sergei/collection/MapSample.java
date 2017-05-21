package org.sergei.collection;

import com.google.common.collect.*;

import java.util.*;

/**
 * Created by Sergei_Doroshenko on 3/2/2017.
 */
public class MapSample {
    public static void main(String[] args) {
        Map<String, Integer> salary = ImmutableMap.<String, Integer>builder()
                .put("John", 1000)
                .put("Jane", 1500)
                .put("Adam", 2000)
                .put("Tom", 2000)
                .build();
        System.out.println(salary);

        Multimap<String, String> multimap = ArrayListMultimap.create();
        multimap.put("fruit", "apple");
        multimap.put("fruit", "banana");
        multimap.put("pet", "cat");
        multimap.put("pet", "dog");
        System.out.println(multimap);

//        Multimap<String, String> multimap2 = ArrayListMultimap.create();
        System.out.println(Integer.MAX_VALUE);
    }


}
