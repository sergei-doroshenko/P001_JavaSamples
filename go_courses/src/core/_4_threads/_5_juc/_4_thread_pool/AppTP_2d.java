package core._4_threads._5_juc._4_thread_pool;

import core.lib.ThreadUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by Sergei on 07.04.2015.
 */
public class AppTP_2d {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newCachedThreadPool();
        List<Future<String>> resutl = pool.invokeAll(Arrays.asList(
                new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        int x = new Random().nextInt(10) * 100;
                        ThreadUtils.sleep(x);
                        return "Hello";
                    }
                },
                new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        int x = new Random().nextInt(10) * 100;
                        ThreadUtils.sleep(x);
                        if (x < 700) throw new RuntimeException("exeption");
                        return "Buy";
                    }
                }
        ));

        for (Future f : resutl) {
            try {
                System.out.println(f.get());
            } catch (Exception e) {
                System.out.println(e.getCause());
            }
        }

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.SECONDS);

    }
}
