package core._3_io._0_charset._1_lab;

/**
 * Created by Sergei on 13.03.2015.
 */
public class App01 {
    public static void main(String[] args) {
        int i_0 = 0b110;
        System.out.println(0b110); // 6
        System.out.println(0b1101_1010); // 218
        System.out.println(0b1101_1010 >> 5); // 6
        System.out.println(Integer.toBinaryString(0b1101_1011 >> 5 & 0b111));
        System.out.println((0b1101_1011 >> 5 & 0b111) == 6);
    }
}
