package org.sergei._0_core._9_bits;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by Sergei on 20.03.2015.
 */
public class App01 {
    public static void main(String[] args) {

        int k = 1_000_000 * 1_000_000;
        System.out.println(k); // -727379968

        BigInteger a = new BigInteger("1000000");
        BigInteger b = new BigInteger("1000000");
        BigInteger c = a.multiply(b);
        System.out.println(c);

        BigDecimal d0 = new BigDecimal(3.05);

        System.out.println(Integer.MAX_VALUE);
        System.out.println(-Integer.MAX_VALUE);
    }
}
