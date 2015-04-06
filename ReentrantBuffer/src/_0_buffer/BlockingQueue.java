package _0_buffer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Sergei on 05.04.2015.
 */
public class BlockingQueue<T> {
    private final Lock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();
    private final T[] items;
    private int head, tail, count;

    public BlockingQueue(int size) {
        this.items = (T[]) new Object[size];
    }

    public void put(T item) throws InterruptedException {
        try {
            lock.lock();
            while(count == items.length) {
                notEmpty.await();
            }
            items[tail] = item;
            if (++tail == items.length) {
                tail = 0;
            }
            count++;
            notFull.signal();
            System.out.println("T-" + Thread.currentThread().getId() +
                    " PUT: " + item);
            /*print();*/
        } finally {
            lock.unlock();
        }

    }

    public T get() throws InterruptedException {
        try {
            lock.lock();
            while(count == 0) {
                notFull.await();
            }
            T item = items[head];
            if (++head == items.length) {
                head = 0;
            }
            count--;
            notEmpty.signal();
            /*print();*/
            return item;
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
