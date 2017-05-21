package org.sergei.collection;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimaps;
import org.apache.commons.collections.MapUtils;

/**
 * Created by Sergei_Doroshenko on 1/19/2017.
 */
public class MapInversion {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Tom", 3);
        map.put("Jack", 4);
        map.put("Anna", 5);
        map.put("Sara", 5);
        System.out.println(map);

        Map<Integer, String> reversedHashMap = MapUtils.invertMap(map);
        System.out.println(reversedHashMap);

        ListMultimap<Integer, String> inverted = Multimaps.invertFrom(Multimaps.forMap(map), ArrayListMultimap.create());
        System.out.println(inverted);
    }
}
