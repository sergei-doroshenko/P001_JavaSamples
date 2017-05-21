package org.sergei._0_core._6_oop._0_type;

/**
 * Created by Sergei on 16.03.2015.
 */
public class App01 {
    public static void main(String[] args) {
        Exception ref0 = new RuntimeException();
        try {
            /*throw ref0;*/ // compilation error unhandled exception
        } catch (RuntimeException e) {

        }

        RuntimeException ref1 = new RuntimeException();
        try {
            throw ref1; // OK!
        } catch (RuntimeException e) {

        }
    }
}
