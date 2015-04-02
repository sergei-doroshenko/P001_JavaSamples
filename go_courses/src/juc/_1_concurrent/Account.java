package juc._1_concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Sergei on 01.04.2015.
 */
public class Account {
    private final int id;
    private final Lock lock;
    private int balance;
    /*private int failCounter;*/
    private AtomicInteger failCounter;


    public Account(int id, int initBalance) {
        this.id = id;
        this.balance = initBalance;
        this.lock = new ReentrantLock();
        this.failCounter = new AtomicInteger(0);
    }

    public void withdraw (int amount) {
        balance -= amount;
    }

    public void deposit(int amount){
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }

    public Lock getLock() {
        return lock;
    }

    public void incFailedTransferCounter(){
        /*failCounter++;*/
        this.failCounter.incrementAndGet();
    }

    public AtomicInteger getFailCounter() {
        return failCounter;
    }
}
