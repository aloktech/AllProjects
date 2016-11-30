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
 * @author Pintu
 */
public class ThreadSampleInteger {

    private static int counter = 0;

    public static void main(String[] args) {
        method1();
        new Thread(() -> {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(ThreadSample.class.getName()).log(Level.SEVERE, null, ex);
//            }
            counter++;
            System.out.println("Inner : " + counter);
        }).start();
    }

    static void method1() {
        counter++;
        System.out.println("Outer : " + counter);
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(ThreadSample.class.getName()).log(Level.SEVERE, null, ex);
//        }
        method2();
    }

    static void method2() {
        counter++;
        System.out.println("Outer : " + counter);
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(ThreadSample.class.getName()).log(Level.SEVERE, null, ex);
//        }
        method3();
    }

    static void method3() {
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(ThreadSample.class.getName()).log(Level.SEVERE, null, ex);
//        }
        counter++;
        System.out.println("Outer : " + counter);
    }
}
