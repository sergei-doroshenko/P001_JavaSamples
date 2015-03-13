package core._5_collections._1_tests;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sergei on 13.03.2015.
 */
public class Test00 {
    static int LIST_LENGTH = 100_000;
    static int OPERATION_COUNT = 100_000;

    public static void main(String[] args) {
        int elementIndex = LIST_LENGTH/2;

        //List<String> list = new LinkedList<>(); // ~ dT: 8538.30362
        List<String> list = new ArrayList<>(); // ~ dT: 3.259354
        // FILL
        for (int i = 0; i < LIST_LENGTH; i++) {
            list.add("A");
        }
        // TEST
        long startTime = System.nanoTime();
        for (int i = 0; i < OPERATION_COUNT; i++) {
            list.get(elementIndex);
        }
        long stopTime = System.nanoTime();
        System.out.println("dT: " + (stopTime - startTime)/1_000_000.0 );
    }
}
