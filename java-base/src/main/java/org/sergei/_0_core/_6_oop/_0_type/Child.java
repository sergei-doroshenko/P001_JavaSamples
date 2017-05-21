package org.sergei._0_core._6_oop._0_type;

/**
 * Created by Sergei on 16.03.2015.
 */
public class Child extends Parent {
    public String name = "Child";

    /*public static void stMethod(){
        System.out.println("Child static method");
    }*/

    @Override
    public void virtMethod() {
        System.out.println("Child virtual method");
    }
}
