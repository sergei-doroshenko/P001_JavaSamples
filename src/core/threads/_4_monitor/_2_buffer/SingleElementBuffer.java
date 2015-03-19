package core.threads._4_monitor._2_buffer;

/**
 * Created by Sergei on 20.02.2015.
 */
public class SingleElementBuffer {
    private int waitedProducers;
    private int waitedConsumers;
    private Integer elem = null;

    public synchronized void put(int newElem) throws InterruptedException {
        while (this.elem != null) { // buffer is full
            waitedProducers++; // increment producers number
            System.out.println("waitedProducers "+ waitedProducers);
            //System.out.println(Thread.currentThread().getName() + " start wait on put");
            this.wait();            // wait while it will be empty
            //System.out.println(Thread.currentThread().getName() + " end wait on put");
            waitedProducers--; // decrement producers number
            System.out.println("waitedProducers "+ waitedProducers);
        }

        this.elem = newElem;
        System.out.println("                                 " + System.currentTimeMillis() + ": puted - " + newElem);
        if (waitedConsumers > 0) {
            this.notify(); /** !!!WARNING !!! if it notified NOT Consumer, BUT Producer we will lost signal and system hangs **/
        }
    }

    public synchronized int get() throws InterruptedException {
        while (this.elem == null) { // buffer is empty
            waitedConsumers++;      // increment waiting consumers
            System.out.println("waitedConsumers " + waitedConsumers);
            //System.out.println(Thread.currentThread().getName() + " start wait on get");
            this.wait();            // wait until it will be with product
            //System.out.println(Thread.currentThread().getName() + " end wait on get");
            waitedConsumers--;      // decrement waiting consumers
            System.out.println("waitedConsumers " + waitedConsumers);
        }

        Integer result = this.elem;
        this.elem = null;
        System.out.println("                                 " + System.currentTimeMillis() + ": geted - " + result);

        if (waitedProducers > 0) {
            this.notify();
        }
        return result;
    }
}
