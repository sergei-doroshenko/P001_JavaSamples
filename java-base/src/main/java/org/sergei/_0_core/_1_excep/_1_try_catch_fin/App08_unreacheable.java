package org.sergei._0_core._1_excep._1_try_catch_fin;

/**
 * Created by Sergei on 17.03.2015.
 *
 * Unreachable statement
 */
public class App08_unreacheable {
    public static void main(String[] args) {
        System.out.println(f());


    }

    private static int f() {
        try {
            throw new Error();

        } finally {
            return 0;
        }

        /*return 1;*/ // Unreachable statement
    }
}
