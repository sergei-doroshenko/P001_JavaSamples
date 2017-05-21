package org.sergei._1_advanced._1_concurrent.serial_executor._1_concurrent;

import org.sergei._0_core.lib.ThreadUtils;

import java.util.concurrent.TimeUnit;

/**
 * Created by Sergei on 01.04.2015.
 */
public class Operations_lock {
    public static void main(String[] args) throws InterruptedException {
        final Account a = new Account(0, 1000);
        final Account b = new Account(1, 2000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        transfer(a, b, 500);
                    } catch (InsufficientFundsException e) {
                        e.printStackTrace();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            transfer(b, a, 300);
        } catch (InsufficientFundsException e) {
            e.printStackTrace();
        }
    }

    private static void transfer(Account from, Account to, int amount) throws InsufficientFundsException, InterruptedException {

        System.out.println("Thread-" + Thread.currentThread().getId() + " Trying to lock account " + from.getId());
        if(from.getLock().tryLock(1000, TimeUnit.MILLISECONDS)) {
            System.out.println("Thread-" + Thread.currentThread().getId() + " lock account " + from.getId());
            ThreadUtils.sleep(100);

            try {
                if (from.getBalance() < amount) {
                    throw new InsufficientFundsException("No funds");
                }
                System.out.println("Thread-" + Thread.currentThread().getId() + " Trying to lock account " + to.getId());
                if (to.getLock().tryLock(1000, TimeUnit.MILLISECONDS)) {
                    try {
                        System.out.println("Thread-" + Thread.currentThread().getId() + " lock account " + to.getId());
                        from.withdraw(amount);
                        to.deposit(amount);
                        System.out.println("Transfer from: " + from.getId() + " to: " + to.getId() + " on: " + amount + " successful." +
                                " New balances: " + from.getId() + " = " + from.getBalance() + "; " + to.getId() + " = " + to.getBalance());
                    } finally {
                        to.getLock().unlock();
                    }
                } else {
                    to.incFailedTransferCounter();
                    System.out.println("ERROR! Transfer from: " + from.getId() + " to: " + to.getId() + " on: " + amount + " unsuccessful." +
                            " New balances: " + from.getId() + " = " + from.getBalance() + "; " + to.getId() + " = " + to.getBalance());
                }

            } finally {
                from.getLock().unlock();
            }


        } else {
            // Error waiting lock
            from.incFailedTransferCounter(); // increment failed counter
            System.out.println("ERROR! Transfer from: " + from.getId() + " to: " + to.getId() + " on: " + amount + " unsuccessful." +
                    " New balances: " + from.getId() + " = " + from.getBalance() + "; " + to.getId() + " = " + to.getBalance());
        }

    }
}
