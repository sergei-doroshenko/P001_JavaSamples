package org.sergei._0_core._6_oop._4_principles.delegation;

import java.util.Collections;
import java.util.List;

/**
 * Created by Sergei on 18.03.2015.
 */
public class Delegation <T extends Comparable<T>> {
    private int k;
    private List<T> list;

    public Delegation(List<T> integers) {
        this.list = integers;
    }

    public T max() {
        return Collections.max(list);
    }

    @Override
    public String toString() {
        return "Delegation{" + max() + "}";
    }
}
