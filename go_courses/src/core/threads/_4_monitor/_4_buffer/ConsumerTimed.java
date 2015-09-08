package core.threads._4_monitor._4_buffer;

import java.util.concurrent.TimeoutException;

/**
 * Created by Sergei on 20.02.2015.
 */
public class ConsumerTimed implements Runnable {
    private final SingleElementBuffer buffer;
    private final long timeout;

    public ConsumerTimed(SingleElementBuffer buffer, long timeout) {
        this.buffer = buffer;
        this.timeout = timeout;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer elem = buffer.get(timeout);
                System.out.println(elem + " consumed");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted");
                return;
            } catch (TimeoutException e) {
                System.out.println(Thread.currentThread().getName() + " timeout");
                return;
            }
        }
    }
}
