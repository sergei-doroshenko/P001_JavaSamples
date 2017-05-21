package org.sergei._0_core._5_collections._1_tests;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sergei on 13.03.2015.
 */
public class Test01 {
    static int LIST_LENGTH = 100_000;
    static int OPERATION_COUNT = 100_000;

    public static void main(String[] args) {
        int elementIndex = 0;

        List<String> list = new LinkedList<>(); // ~ dT: 6.996769
        //List<String> list = new ArrayList<>(); // ~ dT: 3.274252
        // FILL
        for (int i = 0; i < LIST_LENGTH; i++) {
            list.add("A");
        }
        // TEST
        long startTime = System.nanoTime();
        for (int i = 0; i < OPERATION_COUNT; i++) {
            list.set(elementIndex, "B");
        }
        long stopTime = System.nanoTime();
        System.out.println("dT: " + (stopTime - startTime)/1_000_000.0 );
    }
}
