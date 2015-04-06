package _0_buffer;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Sergei on 05.04.2015.
 */
public class WriterTask01 implements Runnable {
    private final BlockingQueue<Integer> queue;
    private final CountDownLatch latch;

    public WriterTask01(BlockingQueue<Integer> queue, CountDownLatch latch) {
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
            try {
                Thread.sleep(rnd.nextInt(10) * 100);
                queue.put(rnd.nextInt(400));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
