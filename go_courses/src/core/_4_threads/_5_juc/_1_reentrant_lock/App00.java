package core._4_threads._5_juc._1_reentrant_lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sergei on 05.04.2015.
 */
public class App00 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        ConditionBoundedBuffer<Integer> buffer = new ConditionBoundedBuffer<>(2);
        int writers = 3, readers = 2;

        for (int i = 0; i < readers; i++) {
            service.submit(new ReaderTask00(buffer));
        }

        for (int i = 0; i < writers; i++) {
            service.submit(new WriterTask00(buffer));
        }

        service.shutdown();
        try {
            service.awaitTermination(10_000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
