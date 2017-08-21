package org.sergei.collection;

import com.google.common.collect.Iterables;

import java.util.Collections;
import java.util.List;

public class GetFirst {
    public static void main(String[] args) {
        List<String> list01 = Collections.emptyList();
        System.out.println(Iterables.getFirst(list01, "default")); // NPE
    }
}
