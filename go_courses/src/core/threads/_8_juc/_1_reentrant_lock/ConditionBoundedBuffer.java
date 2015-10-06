package core.threads._8_juc._1_reentrant_lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Sergei on 19.02.2015.
 */
public class ConditionBoundedBuffer<T> {
    protected final Lock lock = new ReentrantLock();
    // CONDITION PREDICATE: notFull (count < items.length)
    private final Condition notFull = lock.newCondition();
    // CONDITION PREDICATE: notEmpty (count > 0)
    private final Condition notEmpty = lock.newCondition();
    private T[] items;
    private int tail, head, count;

    public ConditionBoundedBuffer(int size) {
        this.items = (T[]) new Object[size];
    }

    // BLOCKS-UNTIL: notFull
    public void put (T x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length){
                notFull.await();
            }

            items[tail] = x;
            if (++tail == items.length){
                tail = 0;
            }
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    // BLOCKS-UNTIL: notEmpty
    public T take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0){
                notEmpty.await();
            }

            T x = items[head];
            items[head] = null;
            if (++head == items.length) {
                head = 0;
            }
            --count;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }
}