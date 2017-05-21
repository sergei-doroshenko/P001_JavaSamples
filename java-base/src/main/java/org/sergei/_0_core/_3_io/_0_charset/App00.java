package org.sergei._0_core._3_io._0_charset;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * Created by Sergei on 02.03.2015.
 */
public class App00 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println("A".getBytes("UTF-16").length);
        System.out.println("AA".getBytes("UTF-16").length);

        System.out.println(Arrays.toString("A".getBytes("US-ASCII")));
        System.out.println(Arrays.toString("A".getBytes("ISO-8859-1")));
        System.out.println(Arrays.toString("A".getBytes("UTF-8")));
        System.out.println(Arrays.toString("A".getBytes("UTF-16")));
        System.out.println(Arrays.toString("A".getBytes("UTF-16BE")));
        System.out.println(Arrays.toString("A".getBytes("UTF-16LE")));
        System.out.println(Arrays.toString("A".getBytes("UTF-32")));
        System.out.println(Arrays.toString("A".getBytes("UTF-32LE")));
        System.out.println(Arrays.toString("A".getBytes("UTF-32LE")));

        char ch;
        ch = 0x0001;
        System.out.println(Arrays.toString(("" + ch).getBytes("UTF-8")));
        ch = 0x0111;
        System.out.println(Arrays.toString(("" + ch).getBytes("UTF-8")));
        ch = 0x1111;
        System.out.println(Arrays.toString(("" + ch).getBytes("UTF-8")));

        byte[] bytes = "AA".getBytes("UTF-16");
        String str0 = new String(bytes); // here used default charset
        System.out.println(str0);
        String str1 = new String(bytes, "UTF-16");
        System.out.println(str1);

    }
}
