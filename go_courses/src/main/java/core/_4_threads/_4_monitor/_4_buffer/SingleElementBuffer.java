package core._4_threads._4_monitor._4_buffer;

import java.util.concurrent.TimeoutException;

/**
 * Created by Sergei on 20.02.2015.
 */
public class SingleElementBuffer {
    private Integer elem = null;

    public synchronized void put(int newElem, long timeout) throws InterruptedException, TimeoutException {
        long waitTime = timeout;
        while (this.elem != null && waitTime > 0) { // buffer is full
            long t0 = System.currentTimeMillis();
            this.wait(waitTime);            // wait while it will be empty
            long t1 = System.currentTimeMillis();
            long elapsedTime = t1 - t0;
            waitTime -= elapsedTime;
        }

        if (elem != null && waitTime <= 0) {
            throw new TimeoutException();
        }

        this.elem = newElem;
        this.notifyAll();
    }

    public synchronized int get(long timeout) throws InterruptedException, TimeoutException {
        long waitTime = timeout;
        while (this.elem == null && waitTime > 0) { // buffer is empty
            long t0 = System.currentTimeMillis();
            this.wait(waitTime);            // wait until it will be with product
            long t1 = System.currentTimeMillis();
            long elapsedTime = t1 - t0;
            waitTime -= elapsedTime;
        }

        if (elem == null && waitTime <= 0) {
            throw new TimeoutException();
        }

        Integer result = this.elem;
        this.elem = null;
        this.notifyAll();
        return result;
    }
}
