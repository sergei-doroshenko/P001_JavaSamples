package org.sergei._0_core._3_io._0_charset;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Created by Sergei on 02.03.2015.
 */
public class App04 {
    public static void main(String[] args) {
        Charset usAscii = StandardCharsets.US_ASCII;
        Charset iso88591 = StandardCharsets.ISO_8859_1;
        System.out.println(iso88591.name());
        System.out.println(iso88591.aliases());
        System.out.println(iso88591.aliases().size());

        Charset utf16 = StandardCharsets.UTF_16;
        Charset utf16be = StandardCharsets.UTF_16BE;
        Charset utf16le = StandardCharsets.UTF_16LE;
        Charset utf8 = StandardCharsets.UTF_8;

        byte[] raw = "ABC".getBytes(StandardCharsets.UTF_8);
    }
}
