package org.sergei._0_core._4_threads._5_juc._8_cyclic_barrier;

import org.sergei._0_core.lib.ThreadUtils;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by Sergei on 10.04.2015.
 */
public class AppCB_0 {
    static final int N = 10;

    public static void main(String[] args) {
        final CyclicBarrier barrier = new CyclicBarrier(N);
        ExecutorService pool = Executors.newCachedThreadPool();

        for (int i = 0; i < N; i++) {
            pool.submit(new Callable<Void>() {
                @Override
                public Void call() throws Exception { // create slaves
                    while (true) {
                        System.out.println("new");
                        ThreadUtils.sleep(new Random().nextInt(10) * 1000);
                        System.out.println("      done");
                        barrier.await(1000, TimeUnit.MILLISECONDS);
                    }
                }
            });
        }
    }
}
