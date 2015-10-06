package core._3_io._0_charset._0_lab;

/**
 * Created by Sergei on 06.03.2015.
 */
public class App {
    public static void main(String[] args) {
        int i = 0b00000001_00000011_10000111_11001111;
        byte b0 = (byte) i;
        System.out.println(b0);
        System.out.println(Integer.toBinaryString(b0 & 0xFF));
        System.out.println(0xF);

        byte b1 = (byte) (i >>> 8);
        System.out.println(b1);
        System.out.println(Integer.toBinaryString(b1 & 0xFF));
    }
}
