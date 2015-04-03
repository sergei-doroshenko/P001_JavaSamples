package juc._1_reentrant_lock;

import core.lib.ThreadUtils;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Sergei on 03.04.2015.
 * Goetz. Java concurrency in practice. EN - page 189
 */
public class ConditionBoundedBuffer<T> {
    protected final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();
    private final T[] items;
    private int tail, head, count;

    public ConditionBoundedBuffer(int size) {
        this.items = (T[]) new Object[size];
    }

    //Blocks until notFull
    public void put(T x) throws InterruptedException {
        lock.lock();
        System.err.println("count: " + count);
        try {
            while (count == items.length) {
                notFull.await();
            }

            items[tail] = x;
            if(++tail == items.length) {
                tail = 0;
            }

            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    //Blocks until notEmpty
    public T get() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }

            T item = items[head];
            if (++head == items.length) {
                head = 0;
            }

            count--;
            notFull.signal();
            return item;
        } finally {
            lock.unlock();
        }
    }
}
