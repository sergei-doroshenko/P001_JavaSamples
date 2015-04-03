package juc._1_reentrant_lock;

import core.lib.ThreadUtils;

/**
 * Created by Sergei on 03.04.2015.
 */
public class ReaderTask implements Runnable {
    private final ConditionBoundedBuffer<Integer> buffer;

    public ReaderTask(ConditionBoundedBuffer<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            ThreadUtils.sleep(1000);
            try {
                System.err.println("Get: " + buffer.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
