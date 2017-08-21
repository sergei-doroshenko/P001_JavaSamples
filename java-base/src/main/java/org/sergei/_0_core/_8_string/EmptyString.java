package org.sergei._0_core._8_string;

import java.util.Arrays;

public class EmptyString {
    public static void main(String[] args) {
        System.out.println(Arrays.toString("".getBytes()));
        System.out.println(Arrays.toString(new byte[]{}));
        System.out.println(String.valueOf(new char[0]));
    }
}
