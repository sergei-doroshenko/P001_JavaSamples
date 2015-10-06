package structural.adapter;

import java.util.Collections;
import java.util.List;

/**
 * Created by Sergei on 17.08.2015.
 */
public class ListSorterer<T extends Comparable<? super T>> {

    public List<T> sort(List<T> list) {
        Collections.sort(list);
        return list;
    }
}
