package _1_java_basics;

/**
 * Created by Sergei on 27.03.2015.
 */
public class App08_binary_view {
    public static void main(String[] args) {
        int a = 0b01110011_11001101_11110011_11001101; // 1_942_877_133
        float f  = 0b01110011_11001101_11110011_11001101; // 1_942_877_133
        byte b0  = (byte) 0b11001101_11110011_11001101; // 1_942_877_133
        byte b1  = 0b011_1101; //
        double d  = 0b01110011_11001101_11110011_11001101; // 1_942_877_133

        System.out.println(a);
    }
}
