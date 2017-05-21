package org.sergei._0_core._7_arrays;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class ArraysSort {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        ComparableTimSort.sort(a, 0, a.length, null, 0, 0);
//        TimSort.sort(a, 0, a.length, c, null, 0, 0);
        String[] data = {"hello", "apple", "zero", "extreme"};
        System.out.println(Arrays.toString(data));

        Class<?> clazz = Class.forName("java.util.TimSort");
        System.out.println(clazz);

        Method method = clazz.getDeclaredMethod("sort", Object[].class, int.class, int.class, Comparator.class, Object[].class, int.class, int.class);
        method.setAccessible(true);
        System.out.println(method);

//        sort(T[] a, int lo, int hi, Comparator<? super T> c, T[] work, int workBase, int workLen)
        method.invoke(null, data, 0, data.length, Comparator.naturalOrder(), null, 0, 0);

        System.out.println(Arrays.toString(data));
    }
}
