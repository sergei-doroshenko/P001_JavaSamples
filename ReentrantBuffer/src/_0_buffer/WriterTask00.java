package _0_buffer;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Sergei on 05.04.2015.
 */
public class WriterTask00 implements Runnable {
    private final BlockingQueue<Integer> queue;

    public WriterTask00(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Random rnd = new Random();

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
