package core._9_bits;

import java.util.HashMap;

/**
 * Created by Sergei on 17.03.2015.
 */
public class App00_mult {
    public static void main(String[] args) {
        int q = 3;
        System.out.println(q * 10);
        System.out.println((q << 3) + (q << 1)); // q * 10
        System.out.println((q << 6) + (q << 5) + (q << 2)); // q * 100
    }
}
