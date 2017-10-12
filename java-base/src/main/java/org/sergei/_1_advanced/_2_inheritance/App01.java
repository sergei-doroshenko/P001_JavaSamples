package org.sergei._1_advanced._2_inheritance;

public class App01 {
    public static void main(String[] args) {
        Child01 child01 = new Child01();
        child01.setParentMember("One");

        Child02 child02 = new Child02();
        child02.setParentMember("Two");

        System.out.println(child01.getParentMember());
        System.out.println(child02.getParentMember());
    }
}
