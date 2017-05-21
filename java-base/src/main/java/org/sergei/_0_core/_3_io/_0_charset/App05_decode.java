package org.sergei._0_core._3_io._0_charset;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Created by Sergei on 02.03.2015.
 */
public class App05_decode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] b0 = "ABC".getBytes(StandardCharsets.US_ASCII);
        System.out.println(Arrays.toString(b0));
        String str0 = new String(b0, StandardCharsets.US_ASCII);
        System.out.println(str0);

        byte[] b1 = str0.getBytes(StandardCharsets.UTF_16LE);
        System.out.println(Arrays.toString(b1));
        String str1 = new String(b1, "UTF-16LE");
        System.out.println(str1);
    }
}
