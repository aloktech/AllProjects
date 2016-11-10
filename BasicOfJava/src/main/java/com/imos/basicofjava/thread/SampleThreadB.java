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
public class SampleThreadB {

    public static void main(String[] args) {

        for (int index = 0; index < 1; index++) {
            Thread thread1 = new Thread(() -> {
                System.out.println("Child 1 Thread terminates");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SampleThreadB.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
//            thread1.setPriority(9);
            thread1.start();
            Thread thread2 = new Thread(() -> {
                System.out.println("Child 2 Thread terminates");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SampleThreadB.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
//            thread2.setPriority(8);
            thread2.start();
            Thread thread3 = new Thread(() -> {
                System.out.println("Child 3 Thread terminates");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SampleThreadB.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
//            thread3.setPriority(7);
            thread3.start();
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(SampleThreadB.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("");
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(SampleThreadB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Main Thread terminates");
    }
}
