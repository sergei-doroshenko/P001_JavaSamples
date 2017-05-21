package org.sergei._0_core._9_bits;

/**
 * Created by sergei on 2/19/16.
 */
public class App05_hex {
    public static void main(String[] args) {
        int a = 0xFF0;
        int b = 0xF0F;
        int c = 0x0FF;

        c = a = (a ^ b | a & b) ^ c;
        System.out.println((c | a) ^ (c & a)); // answer: 0
    }
}
