package core._5_collections._1_tests;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sergei on 13.03.2015.
 */
public class Test02 {
    static int LIST_LENGTH = 100_000;
    static int OPERATION_COUNT = 100_000;

    public static void main(String[] args) {
        int elementIndex = LIST_LENGTH - 1000;
        /*
        when elementIndex = LIST_LENGTH - 1
        LL: ~ dT: 17.385982
        AL: ~ dT: 13.973012

        when elementIndex = LIST_LENGTH - 1000
        LL: ~ dT: 325.140861 (moving by refs loses to arraycopy)
        AL: ~ dT: 58.23832
         */
        //List<String> list = new LinkedList<>(); //
        List<String> list = new ArrayList<>(); //
        // FILL
        for (int i = 0; i < LIST_LENGTH; i++) {
            list.add("A");
        }
        // TEST
        long startTime = System.nanoTime();
        for (int i = 0; i < OPERATION_COUNT; i++) {
            list.add(elementIndex, "B");
            list.remove(elementIndex);
        }
        long stopTime = System.nanoTime();
        System.out.println("dT: " + (stopTime - startTime)/1_000_000.0 );
    }
}
