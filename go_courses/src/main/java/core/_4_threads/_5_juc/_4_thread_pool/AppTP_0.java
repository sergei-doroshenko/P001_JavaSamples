package core._4_threads._5_juc._4_thread_pool;

import core.lib.ThreadUtils;

import java.util.concurrent.*;

/**
 * Created by Sergei on 07.04.2015.
 */
public class AppTP_0 {
    public static void main(String[] args) throws InterruptedException {
//        ExecutorService pool = Executors.newCachedThreadPool();
        ExecutorService pool = new ThreadPoolExecutor(2, 2,
                                60L, TimeUnit.SECONDS,
                                new ArrayBlockingQueue<Runnable>(10));



        pool.submit(new Runnable() {
            @Override
            public void run() {
                ThreadUtils.sleep(1000);
                System.out.println("Hello");
            }
        });
        System.out.println("submit: Hello");
        pool.submit(new Runnable() {
            @Override
            public void run() {
                ThreadUtils.sleep(1000);
                System.out.println("Bye");
            }
        });
        System.out.println("submit: Bye");
        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.SECONDS);
    }
}
