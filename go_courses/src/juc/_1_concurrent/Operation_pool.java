package juc._1_concurrent;

import core.lib.ThreadUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by Sergei on 02.04.2015.
 */
public class Operation_pool {

    public static void main(String[] args) {


        ExecutorService service = Executors.newFixedThreadPool(3);
        final Account acc1 = new Account(0, 1000);
        final Account acc2 = new Account(1, 2000);

        ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(1);
        scheduled.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.err.println("Failed counter: " + (acc1.getFailCounter().get() + acc2.getFailCounter().get()));
            }
        }, 1000, 500, TimeUnit.MILLISECONDS);

        Random rnd = new Random();
        List<Future<Boolean>> results = new ArrayList<>();
        Account from;
        Account to;

        for (int i = 0; i < 10; i++) {
            if (rnd.nextInt(10) % 2 == 0) {
                from = acc1;
                to = acc2;
            } else {
                from = acc2;
                to = acc1;
            }

            results.add(
                    service.submit(
                            new Transfer(i, from, to, rnd.nextInt(10)*100
                            )
                    )
            );
        }



        service.shutdown();

        try {
            service.awaitTermination(2000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        for (Future<Boolean> res : results) {
            try {
                System.out.println(res.get());
            } catch (InterruptedException | ExecutionException e) {
                System.err.println(e.getMessage());
            }

        }

        scheduled.shutdown();
    }
}
