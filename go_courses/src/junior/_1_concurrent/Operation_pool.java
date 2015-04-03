package junior._1_concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Sergei on 02.04.2015.
 */
public class Operation_pool {
    public static AtomicInteger id = new AtomicInteger(0);

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        final Account acc1 = new Account(0, 4000);
        final Account acc2 = new Account(1, 2000);

        ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(1);
        scheduled.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.err.println("Failed counter: " + (acc1.getFailCounter().get() + acc2.getFailCounter().get()));
            }
        }, 1000, 1000, TimeUnit.MILLISECONDS);

        Random rnd = new Random();
        List<Future<Boolean>> results = new ArrayList<>();
        Account from, to;
        CountDownLatch startLatch = new CountDownLatch(1);
        CyclicBarrier barrier = null;
        Transfer[] transfers = new Transfer[10];
        int _1_2_Count = 0;
        for (int i = 0; i < 10; i++) {
            if (rnd.nextInt(10) % 2 == 0) {
                from = acc1;
                to = acc2;
                _1_2_Count++;
            } else {
                from = acc2;
                to = acc1;
            }
            transfers[i] = new Transfer(from, to, rnd.nextInt(10)*100, startLatch, from == acc1);
        }
        final int count = _1_2_Count;
        final long startTime = System.currentTimeMillis();
        barrier = new CyclicBarrier(10, new Runnable() {
            @Override
            public void run() {
                System.out.println("1 -> 2 transfers number: " + count +
                        ", execution time: " + (System.currentTimeMillis() - startTime));
            }
        });

        for (Transfer t: transfers) {
            t.setBarrier(barrier);
            results.add(
                    service.submit(t)
            );
        }

        startLatch.countDown();

        service.shutdown();
        try {
            service.awaitTermination(2000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        for (Future<Boolean> res : results) {
            try {
                System.out.println("EXECUTION RESULT: " + res.get());
            } catch (InterruptedException | ExecutionException e) {
                System.err.println(e.getMessage());
            }

        }

        scheduled.shutdown();
    }
}
