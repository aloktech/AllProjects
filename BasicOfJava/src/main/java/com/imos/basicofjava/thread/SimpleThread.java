/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.basicofjava.thread;

/**
 *
 * @author alok
 */
public class SimpleThread {

    static boolean status;

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getId()
                + " : "
                + Thread.currentThread().getName());

        status = true;
        Thread th1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getId()
                    + " : "
                    + Thread.currentThread().getName());
            int count = 0;
            while (status) {
                count++;
            }
            System.out.println(Thread.currentThread().getName() + " : " + count);
        });
        th1.start();
        status = false;

        status = true;
        Thread th2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getId()
                    + " : "
                    + Thread.currentThread().getName());
            int count = 0;
            while (status) {
                count++;
            }
            System.out.println(Thread.currentThread().getName() + " : " + count);
        });
        th2.start();
        
        status = false;

        System.out.println("done");
    }
}
