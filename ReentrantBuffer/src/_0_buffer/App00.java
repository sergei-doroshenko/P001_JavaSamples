package _0_buffer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sergei on 05.04.2015.
 */
public class App00 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        BlockingQueue<Integer> buffer = new BlockingQueue<>(4);
        int writers = 20, readers = 10;

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
