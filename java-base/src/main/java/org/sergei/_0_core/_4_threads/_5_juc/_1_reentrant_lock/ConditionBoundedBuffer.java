package org.sergei._0_core._4_threads._5_juc._1_reentrant_lock;

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
            /*System.out.println("T-" + Thread.currentThread().getId() +
                    " PUT: " + x);*/
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

    public boolean isEmpty() {
        try {
            lock.lock();
            return count == 0;
        } finally {
            lock.unlock();
        }
    }

    private void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = head; i <= tail; i++) {
            sb.append("[");
            sb.append(items[i]);
            sb.append("]");
        }
        System.out.println(sb.toString());
    }
}
