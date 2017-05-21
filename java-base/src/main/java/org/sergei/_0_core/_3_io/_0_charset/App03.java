package org.sergei._0_core._3_io._0_charset;

import java.util.Arrays;

/**
 * Created by Sergei on 02.03.2015.
 */
public class App03 {
    public static void main(String[] args) {
        char[] chars = Character.toChars(150_000);
        System.out.println(chars);
        System.out.println(chars.length); // 2
        System.out.println((int) chars[0]);
        System.out.println((int) chars[1]);
        System.out.println(Arrays.toString(chars));
    }
}
