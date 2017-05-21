package org.sergei._0_core._10_wrappers;

/**
 * Created by Sergei on 20.03.2015.
 */
public class App00 {
    public static void main(String[] args) {
        Integer kk = null;
        int k = kk; // NullPointerException
        System.out.println(k);
    }
}
