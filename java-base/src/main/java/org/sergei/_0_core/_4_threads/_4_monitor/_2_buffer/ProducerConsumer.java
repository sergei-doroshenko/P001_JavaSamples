package org.sergei._0_core._4_threads._4_monitor._2_buffer;

/**
 * Created by Sergei on 20.02.2015.
 */
public class ProducerConsumer {
    public static void main (String[] args) {
        SingleElementBuffer buffer = new SingleElementBuffer();
        Thread p1 = new Thread(new Producer(1, 1, buffer));
        p1.setName(Producer.class.getSimpleName() + "-1");
        Thread p2 = new Thread(new Producer(100, 1, buffer));
        p2.setName(Producer.class.getSimpleName() + "-2");
        Thread p3 = new Thread(new Producer(1000, 1, buffer));
        p3.setName(Producer.class.getSimpleName() + "-3");
        p1.start();
        p2.start();
        p3.start();

        Thread c1 = new Thread(new Consumer(buffer));
        c1.setName(Consumer.class.getSimpleName() + "-1");
        Thread c2 = new Thread(new Consumer(buffer));
        c2.setName(Consumer.class.getSimpleName() + "-2");
        c2.start();
        c1.start();
    }
}
