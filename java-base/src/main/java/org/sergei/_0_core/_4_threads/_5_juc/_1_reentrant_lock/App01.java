package org.sergei._0_core._4_threads._5_juc._1_reentrant_lock;

import org.sergei._0_core.lib.ThreadUtils;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Sergei on 05.04.2015.
 */
public class App01 {
    public static void main(String[] args) {
        ConditionBoundedBuffer<Integer> buffer = new ConditionBoundedBuffer<>(2);
        CountDownLatch startLatch = new CountDownLatch(1);
        int writers = 4, readers = 4;

        for (int i = 0; i < writers; i++) {
            new Thread(new WriterTask01(buffer, startLatch)).start();
        }

        for (int i = 0; i < readers; i++) {
            new Thread(new ReaderTask01(buffer, startLatch)).start();
        }

        ThreadUtils.sleep(1000);

        startLatch.countDown();
    }
}
