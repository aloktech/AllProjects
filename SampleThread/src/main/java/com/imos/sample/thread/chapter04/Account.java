/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.thread.chapter04;

import clojure.lang.LockingTransaction;
import clojure.lang.Ref;

/**
 *
 * @author Alok
 */
public class Account {

    private final Ref balance;

    public Account(final int initialBalance) {
        balance = new Ref(initialBalance);
    }

    public void deposit(final int amount) throws Exception {
        LockingTransaction.runInTransaction(
                () -> {
                    if (amount > 0) {
                        balance.set(getBalance() + amount);
                    }
                    return null;
                });
    }

    public void withdraw(final int amount) throws Exception {
        LockingTransaction.runInTransaction(
                () -> {
                    if (amount > 0 && getBalance() >= amount) {
                        balance.set(getBalance() - amount);
                    } else {
                        throw new RuntimeException("Not enough money");
                    }
                    return null;
                });
    }

    public int getBalance() {
        return (int) balance.deref();
    }

    public int ensureBalance() {
        balance.touch();
        return getBalance();
    }
}
