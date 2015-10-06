package core._4_threads._5_juc._7_count_down_lantch;

import core.lib.ThreadUtils;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by Sergei on 10.04.2015.
 */
public class AppCDL_0 {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(10);
        ExecutorService pool = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            pool.submit(new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                    while (true) {
                        ThreadUtils.sleep(new Random().nextInt(10) * 10000);
                        System.out.println("ready");
                        latch.countDown();
                        latch.await();

                        System.out.println("start");
                    }
                }
            });
        }
    }
}
