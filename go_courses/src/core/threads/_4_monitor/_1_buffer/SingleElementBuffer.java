package core.threads._4_monitor._1_buffer;

/**
 * Created by Sergei on 20.02.2015.
 */
public class SingleElementBuffer {
    private Integer elem = null;

    public synchronized void put(int newElem) throws InterruptedException {
        while (this.elem != null) { // buffer is full
            this.wait();            // wait while it will be empty
        }

        this.elem = newElem;
        this.notifyAll();
    }

    public synchronized int get() throws InterruptedException {
        while (this.elem == null) { // buffer is empty
            this.wait();            // wait until it will be with product
        }

        Integer result = this.elem;
        this.elem = null;
        this.notifyAll();
        return result;
    }
}
