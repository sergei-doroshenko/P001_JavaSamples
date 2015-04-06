package _0_buffer;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Sergei on 05.04.2015.
 */
public class ReaderTask00 implements Runnable {
    private final BlockingQueue<Integer> queue;

    public ReaderTask00(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Random rnd = new Random();

        while(true) {
            try {
                Thread.sleep(rnd.nextInt(10) * 100);
                System.out.println("T-" + Thread.currentThread().getId() +
                        " GET: " + queue.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
