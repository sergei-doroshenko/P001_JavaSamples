package core._3_io._0_charset;

/**
 * Created by Sergei on 02.03.2015.
 */
public class App02 {
    public static void main(String[] args) {
        char c0 = 65_535;
        char c1 = 0x0000;

        char c2 = 0x0F0F;
        char c6 = '\u0F0F';
        String str = "\u0133\u0F0FABD";
        char c3 = 01345;
        char c4 = 0b10101;

        char c5 = 'Ы';
        System.out.println((int) c5); // code point
        c5 = (char) (c5 + 3);

        byte b = 0;
        b = (byte) (b + 1);


    }
}
