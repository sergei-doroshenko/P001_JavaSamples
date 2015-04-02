package juc._1_concurrent;

import core.lib.ThreadUtils;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sergei on 02.04.2015.
 */
public class Transfer implements Callable<Boolean> {
    private final Account from;
    private final Account to;
    private final int amount;
    private final int id;

    public Transfer(int id, Account from, Account to, int amount) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public Boolean call() throws Exception {

        System.out.println("Thread-" + Thread.currentThread().getId() + " Trying to lock account " + from.getId());
        if(from.getLock().tryLock(3000, TimeUnit.MILLISECONDS)) {
            System.out.println("Thread-" + Thread.currentThread().getId() + " lock account " + from.getId());
            ThreadUtils.sleep((long) Math.random() * 10000);

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
                        System.out.println("Transfer-" + id + " from: " + from.getId() + " to: " + to.getId() + " on: " + amount + " successful." +
                                " New balances: " + from.getId() + " = " + from.getBalance() + "; " + to.getId() + " = " + to.getBalance());
                        return true;
                    } finally {
                        to.getLock().unlock();
                    }
                } else {
                    to.incFailedTransferCounter();
                    System.out.println("ERROR! Transfer-" + id + " from: " + from.getId() + " to: " + to.getId() + " on: " + amount + " unsuccessful." +
                            " New balances: " + from.getId() + " = " + from.getBalance() + "; " + to.getId() + " = " + to.getBalance());
                    return false;
                }

            } finally {
                from.getLock().unlock();
            }


        } else {
            // Error waiting lock
            from.incFailedTransferCounter(); // increment failed counter
            System.out.println("ERROR! Transfer-" + id + " from: " + from.getId() + " to: " + to.getId() + " on: " + amount + " unsuccessful." +
                    " New balances: " + from.getId() + " = " + from.getBalance() + "; " + to.getId() + " = " + to.getBalance());
            return false;
        }
    }
}
