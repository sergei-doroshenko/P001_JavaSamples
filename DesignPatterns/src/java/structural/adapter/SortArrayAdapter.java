package structural.adapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sergei on 17.08.2015.
 */
public class SortArrayAdapter implements Sorterer{

    private ListSorterer<Integer> listSorterer = new ListSorterer<>();

    @Override
    public int[] sort(int[] array) {
        List<Integer> list = new ArrayList<>(array.length);
        for (int i : array) {
            list.add(i);
        }

        listSorterer.sort(list);

        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }

        return array;
    }
}
