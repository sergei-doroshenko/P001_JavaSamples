package _06_GenericsAndCollections.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sergei_Admin on 12.03.2016.
 */
public class ArrayAsKey {
    public static void main(String[] args) {
        Map<int[], String> map = new HashMap<>();
        int[] key1 = new int[] {1,2,3};

        map.put(key1, "Hello");

        int[] key2 = new int[] {1,2,3};
        System.out.println(map.containsKey(key2)); // false
        System.out.println(map.get(key2)); // null

        System.out.println(key1.hashCode()); // 604107971
        System.out.println(key2.hashCode()); // 123961122
    }
}
