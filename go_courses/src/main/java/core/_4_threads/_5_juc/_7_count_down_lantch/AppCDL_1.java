package core._4_threads._5_juc._7_count_down_lantch;

import core.lib.ThreadUtils;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Sergei on 10.04.2015.
 */
public class AppCDL_1 {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latchA = new CountDownLatch(10);
        final CountDownLatch latchB = new CountDownLatch(1);
        ExecutorService pool = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            pool.submit(new Callable<Void>() {
                @Override
                public Void call() throws Exception { // create slaves
                    ThreadUtils.sleep(new Random().nextInt(10) * 100); // slave works
                    System.out.println("ready");
                    latchA.countDown();

                    latchB.await();
                    System.out.println("start");
                    return null;
                }
            });
        }

        latchA.await(); // master wait while slaves finished their work, but doesn't count down latchA
        System.out.println("ALL READY.");
        ThreadUtils.sleep(1000);
        System.out.println("START");
        latchB.countDown(); // slaves waiting to this latch

        pool.shutdown();
    }
}
