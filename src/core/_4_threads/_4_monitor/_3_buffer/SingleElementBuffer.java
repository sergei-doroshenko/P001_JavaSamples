package core._4_threads._4_monitor._3_buffer;

/**
 * Created by Sergei on 20.02.2015.
 */
public class SingleElementBuffer {
    private Integer elem = null;

    public synchronized void put(int newElem) throws InterruptedException {
        while (this.elem != null) { // buffer is full
            this.wait();            // wait while it will be empty
            if (elem != null) {
                this.notify();
            }
        }

        this.elem = newElem;
        this.notify();

    }

    public synchronized int get() throws InterruptedException {
        while (this.elem == null) { // buffer is empty
            this.wait();            // wait until it will be with product
            if (this.elem == null) {
                this.notify();
            }
        }

        Integer result = this.elem;
        this.elem = null;
        notify();

        return result;
    }
}
