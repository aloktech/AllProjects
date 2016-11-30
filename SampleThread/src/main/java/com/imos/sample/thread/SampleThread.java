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
public class SampleThread {

    public SampleThread() {
        SThread thread1 = new SThread();
        System.out.println(thread1.getState().toString());
        thread1.start();
        synchronized (thread1) {
            try {
                thread1.wait(10000);
                System.out.println(thread1.getState().toString());
            } catch (InterruptedException ex) {
                Logger.getLogger(SampleThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(thread1.getState().toString());
    }

    public static void main(String[] args) {
        new SampleThread();
    }
}

class SThread extends Thread {

    @Override
    public void run() {
        System.out.println(getState().toString());
        System.out.println("Thread execution");
        
        synchronized (this) {
            System.out.println("Thread execution synchronized");
            notify();
            System.out.println(getState().toString());
        }
    }
}
