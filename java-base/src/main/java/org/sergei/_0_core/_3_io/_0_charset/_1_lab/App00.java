package org.sergei._0_core._3_io._0_charset._1_lab;

import java.io.*;
import java.util.Arrays;

/**
 * Created by Sergei on 13.03.2015.
 */
public class App00 {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        DataOutput out = new DataOutputStream(buff);
        String str0 = "hЁ\u0911"; // ऑ - '\u0911' - ऑ
        System.out.println("Initial string: '" + str0 + "'");
        out.writeUTF(str0);
        byte[] bytes = buff.toByteArray();
        System.out.println(Arrays.toString(bytes));
        System.out.println(0xFF);
        String str1 = readFromUTF8(bytes);
        System.out.println("readFromUTF8: '" + str1 + "'");
        String str2 = readFromUTF8_2(bytes);
        System.out.println("readFromUTF8_2: '" + str1 + "'");
        testCodePoint(70_000);

        DataInputStream in = new DataInputStream(new ByteArrayInputStream(new byte[]{1,2,3}));
        //in.readUTF();
    }

    private static String readFromUTF8(byte[] bytes) {
        /*
        |------|----------|------------------|-------|----------|----------|----------|
        | bits |  first   |  last            | bytes |  byte 1  |  byte 2  |  byte 3  |
        |------|----------|------------------|-------|----------|----------|----------|
        |   7  | '\u0000' | '\u007F' (0xFF)  |   1   | 0xxxxxxx |          |          |
        |  11  | '\u0080' | '\u07FF' (0x7FF) |   2   | 110ххххх | 10уууууу |          |
        |  16  | '\u0800' | '\UFFFF' (0xFFFF)|   3   | 1110xxxx | 10yyyyyy | 10zzzzzz |
        |------|----------|------------------|-------|----------|----------|----------|
         */

        int len = bytes[0] << 4 | bytes[1];
        System.out.println("len: " + len);
        int[] codePoints = new int[len];
        char[] chars = new char[len];
        int codePointsCount = 0;

        for (int i = 2; i < bytes.length; i++) {
            byte b0 = bytes[i];
            //System.out.println("b0 = " + Integer.toBinaryString(b0)); // 110_10000

            if ((b0 >> 5 & 0b111) == 0b110) { // if yes, we have 2 bytes

                int part1 = (b0 & 0b11_111) << 6;
                System.out.println("part 1: " + Integer.toBinaryString(part1));
                int part2 = (bytes[++i] & 0b111111);
                System.out.println("part 1: " + Integer.toBinaryString(part2));
                int codePoint = part1 | part2;
                System.out.println("codePoint: " + Integer.toBinaryString(codePoint));

                /*System.out.println("part 1: " + Integer.toBinaryString(b0 & 0b11_111));
                byte b1 = bytes[++i]; // get 2nd byte - 10_000001
                System.out.println("part 2 = " + Integer.toBinaryString(b1 & 0b111_111));
                int codePoint = b0 & 0b11_111; // get last 5 bits from 1st byte
                System.out.println("codePoint: " + Integer.toBinaryString(codePoint));
                codePoint <<= 6; // shift it left to reserve place for 2nd byte
                System.out.println("codePoint: " + Integer.toBinaryString(codePoint));
                b1 = (byte) (b1 & 0b111111); // get 6 last bits from 2nd byte
                System.out.println("b1 edited: " + Integer.toBinaryString(b1));
                codePoint = codePoint | b1; // add last 6 bits from 2nd byte to 1st byte
                System.out.println(Integer.toBinaryString(codePoint)); // 10000_000001*/

                codePoints[codePointsCount++] = codePoint;

            } else if ((b0 >> 4 & 0b1111) == 0b1110) { // we have 3 bytes
                int part1 = (b0 & 0b1111) << 12;
                System.out.println("part 1: " + Integer.toBinaryString(part1));
                int part2 = (bytes[++i] & 0b111111) << 6;
                System.out.println("part 1: " + Integer.toBinaryString(part2));
                int part3 = bytes[++i] & 0b111111;
                System.out.println("part 1: " + Integer.toBinaryString(part3));
                int codePoint = part1 | part2 | part3;
                System.out.println("codePoint: " + Integer.toBinaryString(codePoint));

                codePoints[codePointsCount++] = codePoint;

            } else { // we have 1 byte
                System.out.println("codePoint: " + Integer.toBinaryString(b0));
                codePoints[codePointsCount++] = b0;
            }


        }

        System.out.println(Arrays.toString(codePoints));
       /* System.out.println(Arrays.toString(chars));
        System.out.println(new String(chars));*/
        String resutl = new String(codePoints, 0, codePointsCount);
        System.out.println(resutl);
        return resutl;
    }

    public static String readFromUTF8_2 (byte[] bytes) {
        int len = bytes[0] << 4 | bytes[1];
        int[] codePoints = new int[len];
        int codePointsCount = 0;

        for (int i = 2; i < bytes.length; i++) {
            byte b0 = bytes[i];

            if ((b0 >>> 5 & 0b111) == 0b110) { // if yes, we have 2 bytes
                int codePoint = (b0 & 0b11_111) << 6 | (bytes[++i] & 0b111111);
                codePoints[codePointsCount++] = codePoint;

            } else if ((b0 >>> 4 & 0b1111) == 0b1110) { // we have 3 bytes
                int codePoint = (b0 & 0b1111) << 12 | (bytes[++i] & 0b111111) << 6 | (bytes[++i] & 0b111111);
                codePoints[codePointsCount++] = codePoint;

            } else { // we have 1 byte
                codePoints[codePointsCount++] = b0;
            }
        }

        return new String(codePoints, 0, codePointsCount);
    }

    public static void testCodePoint(int codePoint) {
        char[] charArray = Character.toChars(codePoint);
        System.out.println("char[]: " + Arrays.toString(charArray));
        String string = new String(charArray);
        System.out.println("string: " + string);
        System.out.println("string.length:" + string.length());
        System.out.println("string.codePointCount: " + string.codePointCount(0, string.length()));

    }
}
