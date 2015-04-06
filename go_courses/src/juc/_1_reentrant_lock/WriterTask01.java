package juc._1_reentrant_lock;

import core.lib.ThreadUtils;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Sergei on 05.04.2015.
 */
public class WriterTask01 implements Runnable {
    private final ConditionBoundedBuffer<Integer> queue;
    private final CountDownLatch latch;

    public WriterTask01(ConditionBoundedBuffer<Integer> queue, CountDownLatch latch) {
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
                queue.put(rnd.nextInt(400));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
