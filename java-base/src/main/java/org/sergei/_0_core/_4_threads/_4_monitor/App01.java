package org.sergei._0_core._4_threads._4_monitor;

/**
 * Created by Sergei on 20.02.2015.
 */
public class App01 {
    public static void main (String[] args) {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                hello(1);
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                hello(2);
            }
        });

        a.start();
        b.start();

    }

    public static synchronized void hello(int id) {
        System.out.println(id + " - I'm here (A)!"); // all threads pass this phase
        try {
            App01.class.wait(3000);
        } catch (InterruptedException ingnore) { /* NOP */ }
    }
}
