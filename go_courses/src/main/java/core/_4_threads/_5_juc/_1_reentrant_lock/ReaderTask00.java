package core._4_threads._5_juc._1_reentrant_lock;

import java.util.Random;

/**
 * Created by Sergei on 05.04.2015.
 */
public class ReaderTask00 implements Runnable {
    private final ConditionBoundedBuffer<Integer> queue;

    public ReaderTask00(ConditionBoundedBuffer<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Random rnd = new Random();

        while(true) {
//            ThreadUtils.sleep(rnd.nextInt(10) * 100);
            try {
                System.out.println("T-" + Thread.currentThread().getId() +
                        " GET: " + queue.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
