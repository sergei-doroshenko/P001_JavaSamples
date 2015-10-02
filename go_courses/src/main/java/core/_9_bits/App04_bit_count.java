package core._9_bits;

/**
 * Created by Sergei on 02.10.2015.
 */
public class App04_bit_count {
    public static void main(String[] args) {
        Integer sample = 134;
        int mask = 0b0001; // 1 simple one

        System.out.println(mask);

        printInt(sample);
        System.out.println("--------------------------------------------------------");
        printAnswer(20383);
        printAnswer(20);
        printAnswer(83);
        printAnswer(383);
        printAnswer(382397238);
    }

    public static void printInt(int val) {
        System.out.println(Integer.toBinaryString(val));
        System.out.println(Integer.bitCount(val));
    }

    public static void printAnswer(int sample) {
        System.out.println("calcBitCount(" + sample + ") return: " + calcBitCount(sample));
        System.out.println("Integer.bitCount(" + sample + ") return: " + Integer.bitCount(sample));
    }

    public static int calcBitCount(int sample) {
        int bitCount = 0;
        while (sample != 0) {
            if ( (sample & 1) == 1) bitCount++;
            sample >>= 1;
        }
        return bitCount;
    }
}
