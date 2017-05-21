package org.sergei._0_core._4_threads._3_interrupt;

/**
 * Created by Sergei on 20.02.2015.
 */
public class App01 {
    public static void main (String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("hello");
                    for (long k = 0; k < 1_000_000_000; k++);
                }
            }
        });

        t1.start();
        Thread.sleep(1000);
        //t1.destroy(); // throws NoSuchMethodError

        //t1.stop(); // throws new ThreadDeath() which extends Error

        /*t1.suspend();
        Thread.sleep(3000);
        t1.resume();*/
    }
}
