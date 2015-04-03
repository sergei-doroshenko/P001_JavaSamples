package juc._1_reentrant_lock;

import core.lib.ThreadUtils;

import java.util.Random;

/**
 * Created by Sergei on 03.04.2015.
 */
public class WriterTask implements Runnable {
    private final ConditionBoundedBuffer<Integer> buffer;

    public WriterTask(ConditionBoundedBuffer<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        Random rnd = new Random();
        while (true) {
            ThreadUtils.sleep(1000);
            int x = rnd.nextInt(200);
            System.err.println("Put: " + x);
            try {
                buffer.put(x);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
