package org.sergei._0_core._5_collections._4_sorted_map;

import java.util.*;

/**
 * Created by sergei on 2/19/16.
 */
public class App01 {
    public static final List<String> palette;

    static {
        palette = new ArrayList<>();
        palette.addAll(Arrays.asList(new String[]{"black", "red", "white", "green", "orange", "yellow", "gray"})); // - 34 colors
    }


    public static void main(String[] args) {

        SortedMap<Integer, String> colors = new TreeMap<>();

        colors.put(3, "blue");
        colors.put(1, "red");
        colors.put(5, "black");
        colors.put(10, "white");

        System.out.println("Map size: " + colors.size());

        System.out.printf("Min color: %s(%d); Max color: %s(%d)\n",
                colors.get(colors.firstKey()), colors.firstKey(),
                colors.get(colors.lastKey()), colors.lastKey()
        );

        String selected;

        if (colors.size() >= palette.size()) {
            selected = getNextColor(colors.get(colors.firstKey()));
        } else {
            System.out.println("From DB: " + colors.values());
            System.out.println("palette: " + palette);

            Set<String> diff = new HashSet<>(palette);
            diff.removeAll(colors.values());
            System.out.println("diff: " + diff);

            selected = diff.iterator().next();
        }

        System.out.println("Selected color: " + selected);
    }

    public static String getNextColor(String previous) {
        Collections.sort(palette);
        int index = Collections.binarySearch(palette, previous);

        return palette.get((index+1) % palette.size() );
    }
}
