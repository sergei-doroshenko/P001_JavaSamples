package org.sergei._0_core._4_threads._5_juc._0_jmm.juc;

import org.sergei._0_core.lib.ThreadUtils;

/**
 * Created by Sergei on 03.04.2015.
 */
public class AppJMM {
    /*
    Here volatile can help. Without this second thread read 'ready' (false) into cache
    and doesn't see (go to infinite loop) when firs thread change it in true.
    It's enough to set volatile keyword for only one variable to make happens-before relationship
    between two threads (see J.Bloch Effective Java 2nd ed. It.66).
     */
    static /*volatile*/ boolean ready = false;
    static int data = 0;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadUtils.sleep(1000);
                data = 1;
                ready = true;
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(!ready);
                System.out.println(data); // can print 1 or 0
            }
        }).start();
    }
}
