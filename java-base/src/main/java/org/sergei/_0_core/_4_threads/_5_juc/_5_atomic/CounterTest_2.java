package org.sergei._0_core._4_threads._5_juc._5_atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Sergei on 09.04.2015.
 */
public class CounterTest_2 {
    public static final int N = 1_000_000_000;
    static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread t0 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < N; i++) {
                    counter.incrementAndGet();
                }
            }
        });

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < N; i++) {
                    counter.incrementAndGet();
                }
            }
        });

        t0.start();
        t1.start();

        t0.join();
        t1.join();

        System.out.printf(counter.toString());

    }
}
