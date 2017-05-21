package org.sergei._0_core._6_oop._7_classload;

/**
 * Created by Sergei on 17.03.2015.
 */
public class App00 {
    public static void main(String[] args) {
        try {
            Test0 test0 = new Test0();
        } catch (Error e) {

        }
        Test0 test0 = new Test0();
        // Could not initialize class Test0
        // NoClassDefFoundError
    }
}

class Test0 {
    static {
        System.err.println("static");
        if (true) throw new Error();
    }
}
