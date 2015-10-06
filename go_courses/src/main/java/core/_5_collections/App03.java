package core._5_collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Sergei on 12.03.2015.
 */
public class App03 {
    public static void main(String[] args) {
        String[] strArray = {"A", "B", "C"};
        Object[] objArray = strArray;
        objArray[0] = new Integer(1); // runtime error, ArrayStoreException
        String str0 = strArray[0];
        System.out.println(str0);

        List<String> strList = new ArrayList<>();
        // List<Object> objList = strList; // compilation error, type mismatch
        List<? extends Object> objList = strList; // OK
        // objList.set(0, new Integer(1)); // compilation error
        String str1 = strList.get(0);
        System.out.println(str1);
    }
}
