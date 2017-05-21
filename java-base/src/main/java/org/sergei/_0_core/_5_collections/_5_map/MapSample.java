package org.sergei._0_core._5_collections._5_map;

import java.util.HashMap;
import java.util.Map;

public class MapSample {
    public static void main(String[] args) {
        Map<String, Long> map01 = new HashMap<>();
        map01.put("one", 10L);
        map01.put("two", 3L);

        System.out.println(map01.get("one") > 0);
        System.out.println(map01.getOrDefault("five", 0L) > 0);

    }
}
