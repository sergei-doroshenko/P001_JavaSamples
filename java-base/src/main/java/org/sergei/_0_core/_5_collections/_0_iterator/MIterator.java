package org.sergei._0_core._5_collections._0_iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Sergei Doroshenko on Listing_14_14.03.2015.
 */
public class MIterator<T, E> implements Iterator {
    private Iterator<T> iter0; // 1st iterator
    private Iterator<E> iter1; // 2nd iterator

    private List<T> list0; // list to store elements from 1st iterator
    private List<E> list1; // list to store elements from 2nd iterator
    private int count0; // counter for 1st list
    private int count1; // counter for 2nd list
    private List result; // result that return by next() method

    public MIterator(Iterator<T> iter0, Iterator<E> iter1) {
        this.iter0 = iter0;
        this.iter1 = iter1;
        this.list0 = new ArrayList<>();
        this.list1 = new ArrayList<>();
    }

    @Override
    public boolean hasNext() {
        boolean flag0, flag1;
        flag0 = flag1 = true;

        /* if we don't have enough objects in 1st list */
        if (list0.size() == 0 || list0.size() <= count0) {
            if (iter0.hasNext()) { // check it we have next object in iterator, if yes
                /* add next element to 1st list from 1st iterator */
                list0.add(iter0.next());
                /* as we need to iterate through all element of 2nd list with new element
                * set counter of 2nd list to zero
                * e.g. we add "B" so we need to iterate from 1 to N with "B"
                 * B1, B2, B3 ... BN */
                count1 = 0; //
            } else {                         // if 1st iterator doesn't have elements
                flag0 = false;               // set it's flag to false
                if (iter1.hasNext()) {       // than check maybe 2nd iterator still has elements, if yes
                    list1.add(iter1.next()); // add next element to 2nd list
                    count1++;                // increment 2nd counter
                    count0 = 0;              // set to zero 1st counter, because we have to start form
                } else {                     // the beginning (0 - index)
                    flag1 = false;
                }
            }
//            System.out.println("list0: " + list0);
        }
        /* if we don't have enough objects in 2nd list, do the same as with 1st list */
        if (list1.size() == 0 || list1.size() <= count1) {
            if (iter1.hasNext()) {
                list1.add(iter1.next());
                count0 = 0;
            } else {                          // if 2nd iterator doesn't have elements
                flag1 = false;                // set flag to false
                if (iter0.hasNext()) {        // than check maybe 1st iterator has elements, if yes
                    list0.add(iter0.next());  // add next element to 1st list
                    count0++;                 // increment 1st counter
                    count1 = 0;               // set to zero 2nd counter
                } else {
                    flag0 = false;
                }
            }
//            System.out.println("list1: " + list1);
        }

        if (!flag0 && !flag1) { // if both iterators doesn't have elements
            return false;       // return false
        }

        result = new ArrayList();      // create result object
        result.add(list0.get(count0)); // add element from 1st list
        result.add(list1.get(count1)); // add element from 2nd list

        /* increment counters  */
        if (count0 >= count1) {
            count1++;
        } else if (count0 < count1) {
            count0++;
        }

        return result != null;
    }

    @Override
    public Object next() {
        List temp = result;
        result = null;
        return temp;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        MIterator<String, Integer> mIterator = new MIterator(Arrays.asList("A", "B", "C").iterator(),
                Arrays.asList(1, 2, 3, 4, 5).iterator());

        while (mIterator.hasNext()) {
            System.out.println(mIterator.next());
        }
    }

}
