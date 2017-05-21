package org.sergei._0_core._0_proc.dds;

public class IfElse {
    public static void main(String[] args) {
        ifElse("a", "b");
        ifElse(null, "b");
        ifElse("a", null);
        ifElse(null, null);
    }

    public static void ifElse(String a, String b) {
        if (a != null && b != null) {
            System.out.println("a not null and b not null");
        } else if (a != null) {
            System.out.println("a not null");
        } else if (b != null) {
            System.out.println("b not null");
        } else {
            System.out.println("else");
        }
    }
}
