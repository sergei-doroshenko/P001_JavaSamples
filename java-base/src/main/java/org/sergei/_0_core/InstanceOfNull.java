package org.sergei._0_core;

public class InstanceOfNull {
    public static void main(String[] args) {
        String test01 = null;
        System.out.println(test01 instanceof String); // false

        String test02 = "hello";
        System.out.println(test02 instanceof String); // true
    }
}
