package org.sergei._0_core._4_threads._5_juc._1_reentrant_lock;

import org.sergei._0_core.lib.ThreadUtils;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Sergei on 05.04.2015.
 */
public class ReaderTask01 implements Runnable {
    private final ConditionBoundedBuffer<Integer> queue;
    private final CountDownLatch latch;

    public ReaderTask01(ConditionBoundedBuffer<Integer> queue, CountDownLatch latch) {
        this.queue = queue;
        this.latch = latch;
    }

    @Override
    public void run() {
        Random rnd = new Random();

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while(true) {
            ThreadUtils.sleep(rnd.nextInt(10) * 100);
            try {
                System.out.println("T-" + Thread.currentThread().getId() + " GET: " + queue.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
