package org.sergei._0_core._4_threads._4_monitor._2_buffer;

/**
 * Created by Sergei on 20.02.2015.
 */
public class Consumer implements Runnable {
    private final SingleElementBuffer buffer;

    public Consumer(SingleElementBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer elem = buffer.get();
                System.out.println(System.currentTimeMillis() + ": " + Thread.currentThread().getName() + "  " + elem + " consumed");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted");
                return;
            }
        }
    }
}
