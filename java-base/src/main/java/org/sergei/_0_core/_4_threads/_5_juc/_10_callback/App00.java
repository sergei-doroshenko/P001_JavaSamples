package org.sergei._0_core._4_threads._5_juc._10_callback;

import org.sergei._0_core.lib.ThreadUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sergei on 09.04.2015.
 */
public class App00 {
    private static final List<Callback> callbackList = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();

        Callback cb = new MessageCallback(callbackList);
        //callbackList.add(cb);
        pool.submit(new Job(1, cb));
        pool.submit(new Job(2, new MessageCallback(callbackList)));
        pool.submit(new Job(3, new MessageCallback(callbackList)));
        System.out.println(callbackList.size());

        ThreadUtils.sleep(5000);

        System.out.println(callbackList.size());

        pool.shutdown();
        pool.awaitTermination(5, TimeUnit.SECONDS);
    }
}
