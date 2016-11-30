/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.thread.chapter04;

import clojure.lang.LockingTransaction;

/**
 *
 * @author Alok
 */
public class AccountService {
  public static void transfer(final Account from, final Account to, final int amount) {
    try {
      LockingTransaction.runInTransaction(
          () -> {
            to.deposit(amount);
            from.withdraw(amount);
            return null;
          });
    } catch (Exception ex) {
      System.out.println("Error " + ex.getMessage());
    }
  }

  public static void withdrawConstained(final Account relatedAccount, final Account from, final int amount) {
    //1000
    try {
      LockingTransaction.runInTransaction(
          () -> {
            int totalBalance = from.getBalance() + relatedAccount.ensureBalance();
            if (totalBalance - amount > 1000) {
              from.withdraw(amount);
            } else {
              throw new RuntimeException("Oops constraint violated for " + from);
            }
            return null;
          });
    } catch (Exception ex) {
      System.out.println("Error: " + ex.getMessage());
    }
  }
}
