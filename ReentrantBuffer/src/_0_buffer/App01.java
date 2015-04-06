package _0_buffer;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Sergei on 05.04.2015.
 */
public class App01 {
    public static void main(String[] args) {
        BlockingQueue<Integer> buffer = new BlockingQueue<>(2);
        CountDownLatch startLatch = new CountDownLatch(1);
        int writers = 4, readers = 4;


        for (int i = 0; i < writers; i++) {
            new Thread(new WriterTask01(buffer, startLatch)).start();
        }

        for (int i = 0; i < readers; i++) {
            new Thread(new ReaderTask01(buffer, startLatch)).start();
        }

        try {
            Thread.currentThread().sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        startLatch.countDown();
    }
}
