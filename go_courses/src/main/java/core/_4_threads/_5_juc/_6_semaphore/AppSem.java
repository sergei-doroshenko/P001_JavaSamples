package core._4_threads._5_juc._6_semaphore;

import core.lib.ThreadUtils;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Sergei on 10.04.2015.
 */
public class AppSem {
    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(5);
        ExecutorService pool = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            pool.submit(new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                    while (true) {
                        semaphore.acquire();
                        System.out.println("->");
                        ThreadUtils.sleep(new Random().nextInt(10) * 10);
                        semaphore.release();
                        System.out.println("   <-");
                    }
                }
            });
        }
    }
}
