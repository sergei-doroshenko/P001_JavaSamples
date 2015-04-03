package juc._1_reentrant_lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sergei on 03.04.2015.
 */
public class App00 {
    public static void main(String[] args) {
        final ConditionBoundedBuffer<Integer> buffer = new ConditionBoundedBuffer<>(4);
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            service.submit(new WriterTask(buffer));
        }

        for (int i = 0; i < 10; i++) {
            service.submit(new ReaderTask(buffer));
        }
        service.shutdown();
        try {
            service.awaitTermination(2000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
