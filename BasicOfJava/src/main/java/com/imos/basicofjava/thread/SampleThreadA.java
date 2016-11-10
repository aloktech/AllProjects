/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.basicofjava.thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author INVCH018
 */
public class SampleThreadA {

    static {
        System.out.println("Current State : " + Thread.currentThread().getState().name());
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Current Thread : " + Thread.currentThread().getName());
        System.out.println("Current Id : " + Thread.currentThread().getId());
        System.out.println("Current Priority : " + Thread.currentThread().getPriority());
        System.out.println("Current State : " + Thread.currentThread().getState().name());
        System.out.println("");
        Thread thread = new Thread(() -> {
            System.out.println("1.Thread has name : " + Thread.currentThread().getName() + " and state : "+Thread.currentThread().getState().name());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(SampleThreadA.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("2.Thread has name : " + Thread.currentThread().getName() + " and state : "+Thread.currentThread().getState().name());
        });
        System.out.println("3.Current State : " + thread.getState().name());
        thread.start();
        System.out.println("4.Thread has name : " + thread.getName() + " and state : "+thread.getState().name());
        synchronized (thread) {
            System.out.println("5.Thread has name : " + thread.getName() + " and state : "+thread.getState().name());
            thread.yield();
            System.out.println("6.Thread has name : " + thread.getName() + " and state : "+thread.getState().name());
        }
        System.out.println("7.Thread has name : " + thread.getName() + " and state : "+thread.getState().name());
        Thread.sleep(2100);
        System.out.println("8.Thread has name : " + thread.getName() + " and state : "+thread.getState().name());
    }
}

class SampleThread implements Runnable {

    Thread thread;

    public SampleThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        System.out.println("Current State : " + thread.getState().name());
    }

}
