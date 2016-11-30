/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.thread.chapter04;

/**
 *
 * @author Alok
 */
public class Sample {

    public static void main(String[] args) throws Exception {
        final Account account1 = new Account(1000);
        final Account account2 = new Account(1000);

        System.out.println(account1);
        System.out.println(account2);
        new Thread(() -> AccountService.withdrawConstained(account1, account2, 600)).start();
        new Thread(() -> AccountService.withdrawConstained(account2, account1, 600)).start();

        Thread.sleep(5000);
        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());
    }
}
