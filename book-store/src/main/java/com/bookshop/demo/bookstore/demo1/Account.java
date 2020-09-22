package com.bookshop.demo.bookstore.demo1;

import java.util.concurrent.atomic.AtomicInteger;


public class Account {

    private volatile AtomicInteger balance;

    public Account() {
        this.balance = new AtomicInteger();
    }

    synchronized void transfer(Account target, int amt) {
        if (this.balance.get() > amt) {
            this.balance.getAndAdd( -amt);
            target.balance.getAndAdd( amt);
        }
    }

    public int getBalance() {
        return balance.get();
    }

    public Account setBalance(int balance) {
        this.balance.set(balance);
        return this;
    }
}
