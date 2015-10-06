package core._4_threads._5_juc._9_concurrent_map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by Sergei on 10.04.2015.
 */
public class AppCM {
    public static void main(String[] args) {
        ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>(1024, 0.75f, 64);
//        ConcurrentMap<String, Integer> map = new ConcurrentSkipListMap<>();

        Map<String, Integer> map2 = Collections.synchronizedMap(new HashMap<String, Integer>()); // decorator
        Map<String, Integer> map3 = new Hashtable<String, Integer>();

        map.putIfAbsent("A", 0);
        map.replace("A", 0, 1);
        map.remove("A", 1);
    }
}
