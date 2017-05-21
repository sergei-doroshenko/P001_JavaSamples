package org.sergei._0_core._4_threads._5_juc._3_read_write_lock;

import org.sergei._0_core.lib.ThreadUtils;

import java.util.concurrent.locks.Lock;

/**
 * Created by Sergei on 07.04.2015.
 */
public class Locker implements Runnable {
    private final Lock lock;
    private final Type type;

    public Locker(Lock lock, Type type) {
        this.lock = lock;
        this.type = type;
    }

    @Override
    public void run() {

        String msg = type + "(T-" + Thread.currentThread().getId() + ")";
        System.out.println(msg + " created.");
        /*while (true) {*/
            try {
                lock.lock();
                System.out.println(msg + " start " + type.message + "....");
                ThreadUtils.sleep(5000); // Emulate some work
                System.out.println(msg + " finish " + type.message + "....");
            } finally {
                lock.unlock();
            }
//            ThreadUtils.sleep(3000);
        /*}*/
    }

    enum Type {READER("read"), WRITER("write");
        private String message;

        Type(String messge) {
            this.message = messge;
        }
    }
}
