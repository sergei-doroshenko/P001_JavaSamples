package core._4_threads._5_juc._4_thread_pool;

import core.lib.ThreadUtils;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by Sergei on 07.04.2015.
 */
public class AppTP_2c {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newCachedThreadPool();
        String resutl = pool.invokeAny(Arrays.asList(
                new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        ThreadUtils.sleep(new Random().nextInt(10) * 100);
                        return "Hello";
                    }
                },
                new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        ThreadUtils.sleep(new Random().nextInt(10) * 100);
                        return "Buy";
                    }
                }
        ));
        System.out.println(resutl);
        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.SECONDS);

    }
}
