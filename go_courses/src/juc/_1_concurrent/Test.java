package juc._1_concurrent;

import java.util.Random;

/**
 * Created by Sergei on 02.04.2015.
 */
public class Test {
    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 0; i < 100; i++)
            System.out.println(r.nextLong());
    }
}
