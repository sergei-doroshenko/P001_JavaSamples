package juc._1_reentrant_lock;

import core.lib.ThreadUtils;

import java.util.Random;

/**
 * Created by Sergei on 05.04.2015.
 */
public class WriterTask00 implements Runnable {
    private final ConditionBoundedBuffer<Integer> queue;

    public WriterTask00(ConditionBoundedBuffer<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Random rnd = new Random();

        while(true) {
//            ThreadUtils.sleep(rnd.nextInt(10) * 100);
            try {
                queue.put(rnd.nextInt(400));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
