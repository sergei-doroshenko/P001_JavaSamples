package org.sergei._0_core._4_threads._4_monitor._2_buffer;

import org.sergei._0_core.lib.ThreadUtils;

/**
 * Created by Sergei on 20.02.2015.
 */
public class Producer implements Runnable {
    private int startValue;
    private final int period;
    private final SingleElementBuffer buffer;

    public Producer(int startValue, int period, SingleElementBuffer buffer) {
        this.period = period;
        this.buffer = buffer;
        this.startValue = startValue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(System.currentTimeMillis() + ": " + Thread.currentThread().getName() + "  " + startValue + " produced");
                buffer.put(startValue++);
                ThreadUtils.sleep(period);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted");
                break;
            }
        }
    }
}
