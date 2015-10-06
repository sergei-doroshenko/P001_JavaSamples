package core._5_collections;

import core._0_proc.loop.sort.SelectionSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sergei on 11.03.2015.
 */
public class App00 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println(list);
        list.add(1, "X");
        System.out.println(list);
        list.set(0, "*");
        System.out.println(list);
        System.out.println(list.get(3));
        list.remove(2);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        System.out.println(list.remove("XXX"));

        /* immutable */
        List<String> list_1 = Arrays.asList("A", "B", "C");
        System.out.println(list_1);
        System.out.println(list_1.getClass().getName());

        List<String> list_2 = new ArrayList(Arrays.asList("A", "B", "C"));
        list_2.add("D");
        System.out.println(list_2);
    }

}
