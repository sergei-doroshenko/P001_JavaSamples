package org.sergei._1_advanced._1_concurrent;

import org.sergei._0_core.lib.ThreadUtils;

/**
 * Created by Sergei on 01.04.2015.
 */
public class Operations_herarchy {
    public static void main(String[] args) {
        final Account a = new Account(0, 1000);
        final Account b = new Account(1, 2000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    transfer(a, b, 500);
                } catch (InsufficientFundsException e) {
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

    private static void transfer(Account from, Account to, int amount) throws InsufficientFundsException{
        if (to.getBalance() < amount) {
            throw new InsufficientFundsException("No funds");
        }
        Account acc1, acc2;
        if (from.getId() < to.getId()) {
            acc1 = from;
            acc2 = to;
        } else {
            acc1 = to;
            acc2 = from;
        }

        System.out.println("Thread-" + Thread.currentThread().getId() + " Trying to lock account " + from.getId());
        synchronized (acc1) {
            System.out.println("Thread-" + Thread.currentThread().getId() + " lock account " + from.getId());
            ThreadUtils.sleep(100);
            System.out.println("Thread-" + Thread.currentThread().getId() + " Trying to lock account " + to.getId());
            synchronized (acc2) {
                System.out.println("Thread-" + Thread.currentThread().getId() + " lock account " + to.getId());
                to.withdraw(amount);
                from.deposit(amount);
            }
        }

        System.out.println("Transfer from: " + from.getId() + " to: " + to.getId() + " on: " + amount + " successful." +
                " New balances: " + from.getId() + " = " + from.getBalance() + "; " + to.getId() + " = " + to.getBalance());
    }
}
