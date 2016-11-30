/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alok
 */
public class Thread1 {

    public static void main(String[] args) throws InterruptedException {

        SampleThread1 st1 = new SampleThread1();
        Thread thread1 = new Thread(st1);
        thread1.setName("A");
        thread1.setPriority(1);
        st1.startThread();

        SampleThread1 st2 = new SampleThread1();
        Thread thread2 = new Thread(st2);
        thread2.setName("B");
        thread2.setPriority(9);
        st2.startThread();

        thread1.start();
        thread2.start();

        st1.endThread();
        st2.endThread();
    }
}

class SampleThread1 implements Runnable {

    private boolean a;

    @Override
    public void run() {
        System.out.println("Thread execute : " + Thread.currentThread().getName());
        while (a == true) {

        }
        System.out.println("Thread ends : " + Thread.currentThread().getName());
    }

    public synchronized void startThread() {
        a = true;
    }

    public synchronized void endThread() {
        a = false;
    }
}
