package org.sergei._0_core._4_threads._5_juc._4_thread_pool;

import org.sergei._0_core.lib.ThreadUtils;

import java.util.concurrent.*;

/**
 * Created by Sergei on 07.04.2015.
 */
public class AppTP_2a {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newCachedThreadPool();
        Future<String> futureResult = pool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                ThreadUtils.sleep(1000);
                return "Hello";
            }
        });

        while (true) {
            if (futureResult.isDone()) {
                System.out.println("done: " + futureResult.get());
                break;
            } else {
                System.out.println("wait....");
                ThreadUtils.sleep(100);
            }
        }
        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.SECONDS);

    }
}
