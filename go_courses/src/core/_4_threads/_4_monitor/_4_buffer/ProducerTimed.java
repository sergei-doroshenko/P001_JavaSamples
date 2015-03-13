package core._4_threads._4_monitor._4_buffer;

import core.lib.ThreadUtils;

import java.util.concurrent.TimeoutException;

/**
 * Created by Sergei on 20.02.2015.
 */
public class ProducerTimed implements Runnable {
    private int startValue;
    private final int period;
    private final SingleElementBuffer buffer;
    private final long timeout;

    public ProducerTimed(int startValue, int period, SingleElementBuffer buffer, long timeout) {
        this.period = period;
        this.buffer = buffer;
        this.startValue = startValue;
        this.timeout = timeout;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(startValue + " produced");
                buffer.put(startValue++, timeout);
                ThreadUtils.sleep(period);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted");
                break;
            } catch (TimeoutException e) {
                System.out.println(Thread.currentThread().getName() + " timeout");
                return;
            }
        }
    }
}
