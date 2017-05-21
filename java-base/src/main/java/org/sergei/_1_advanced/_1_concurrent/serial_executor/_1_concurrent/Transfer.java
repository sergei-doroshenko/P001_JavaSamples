package org.sergei._1_advanced._1_concurrent.serial_executor._1_concurrent;

import org.sergei._0_core.lib.ThreadUtils;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sergei Doroshenko on 02.04.2015.
 */
public class Transfer implements Callable<Boolean> {
    private static ThreadLocal<Integer> localID = new ThreadLocal() {
        @Override
        protected Integer initialValue() {
            return Operation_pool.id.getAndIncrement();
        }
    };

    private final Account from;
    private final Account to;
    private final int amount;
    private final CountDownLatch latch;
    private CyclicBarrier barrier;
    private final boolean isFirst;



    public Transfer(Account from, Account to, int amount,
                    CountDownLatch latch, boolean isFirst) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.latch = latch;
        this.isFirst = isFirst;
    }

    /*public Transfer(Account from, Account to, int amount,
                    CountDownLatch latch, CyclicBarrier barrier, boolean isFirst) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.latch = latch;
        this.barrier = barrier;
        this.isFirst = isFirst;
    }*/

    @Override
    public Boolean call() throws Exception {
        int old = localID.get();
        localID.set(old + 1);
        System.out.println("Called Transfer: old = " + old + ", new = " + localID.get());

        System.err.println("Thread-" + Thread.currentThread().getId() + " waiting to start... ");
        latch.await();

        if (!isFirst) {
            System.err.println("Thread-" + Thread.currentThread().getId() + " waiting at barrier... (" + barrier.getNumberWaiting() + ")");
            barrier.await();
        }
        System.err.println("Thread-" + Thread.currentThread().getId() + " started.");

        for (;;) {

            System.out.println("Thread-" + Thread.currentThread().getId() + " Trying to lock account " + from.getId());
            if (from.getLock().tryLock(3000, TimeUnit.MILLISECONDS)) {
                System.out.println("Thread-" + Thread.currentThread().getId() + " lock account " + from.getId());
                ThreadUtils.sleep((long) Math.random() * 1000);

                try {
                    if (from.getBalance() < amount) {
                        throw new InsufficientFundsException("No enough funds on account-" + from.getId() +
                                ". Current: " + from.getBalance() + ", need: " + amount);
                    }
                    System.out.println("Thread-" + Thread.currentThread().getId() + " Trying to lock account " + to.getId());

                    if (to.getLock().tryLock(3000, TimeUnit.MILLISECONDS)) {
                        try {
                            System.out.println("Thread-" + Thread.currentThread().getId() + " lock account " + to.getId());
                            from.withdraw(amount);
                            to.deposit(amount);
                            System.out.println("Transfer-" + localID.get() + " from: " + from.getId() + " to: " + to.getId() + " on: " + amount + " successful." +
                                    " New balances: " + from.getId() + " = " + from.getBalance() + "; " + to.getId() + " = " + to.getBalance());
                            return true;
                        } finally {
                            to.getLock().unlock();
                            System.out.println("Thread-" + Thread.currentThread().getId() + " unlock account " + to.getId());
                        }
                    } else {
                        to.incFailedTransferCounter();
                        System.out.println("ERROR! Transfer-" + localID.get() + " from: " + from.getId() + " to: " + to.getId() + " on: " + amount + " unsuccessful." +
                                " New balances: " + from.getId() + " = " + from.getBalance() + "; " + to.getId() + " = " + to.getBalance());
                        /*return false;*/
                    }

                } finally {
                    from.getLock().unlock();
                    System.out.println("Thread-" + Thread.currentThread().getId() + " unlock account " + from.getId());
                    if (isFirst) {
                        System.out.println("Thread-" + Thread.currentThread().getId() + " waiting at barrier... (" + barrier.getNumberWaiting() + ")");
                        barrier.await();
                    }

                }

            } else {
                // Error waiting lock
                from.incFailedTransferCounter(); // increment failed counter
                System.out.println("ERROR! Transfer-" + localID.get() + " from: " + from.getId() + " to: " + to.getId() + " on: " + amount + " unsuccessful." +
                        " New balances: " + from.getId() + " = " + from.getBalance() + "; " + to.getId() + " = " + to.getBalance());
                /*return false;*/
            }
        }
    }

    public void setBarrier(CyclicBarrier barrier) {
        this.barrier = barrier;
    }
}
