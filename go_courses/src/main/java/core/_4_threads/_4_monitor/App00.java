package core._4_threads._4_monitor;

import core.lib.ThreadUtils;

/**
 * Created by Sergei on 20.02.2015.
 */
public class App00 {
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

    public static void hello(int id) {
        System.out.println(id + " - I'm here (A)!"); // all threads pass this phase
        // while (true); // infinite loop
        synchronized (App00.class) {
            System.out.println(id + " - I'm here (B)!"); // only one thread can pass this phase
            ThreadUtils.sleep(3000);
        }

    }
}
