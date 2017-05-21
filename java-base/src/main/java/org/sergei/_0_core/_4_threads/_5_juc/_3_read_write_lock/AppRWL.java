package org.sergei._0_core._4_threads._5_juc._3_read_write_lock;

import org.sergei._0_core.lib.ThreadUtils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Sergei on 07.04.2015.
 */
public class AppRWL {
    public static void main(String[] args) {
        final ReadWriteLock lock = new ReentrantReadWriteLock();
        final Lock readLock = lock.readLock();
        final Lock writeLock = lock.writeLock();
        // RR
        new Thread(new Locker(readLock, Locker.Type.READER)).start();
        new Thread(new Locker(writeLock, Locker.Type.WRITER)).start();
        ThreadUtils.sleep(2000);
        new Thread(new Locker(readLock, Locker.Type.READER)).start();

        // RW
        new Thread(new Locker(readLock, Locker.Type.READER)).start();

    }

}
