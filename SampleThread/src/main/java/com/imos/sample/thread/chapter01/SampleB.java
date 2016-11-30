/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.thread.chapter01;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alok
 */
public class SampleB {

//    private static volatile boolean done = false;
    private static boolean done = false;
    private static int count;

    public static void main(String[] args) {
        new Thread(() -> {
            while (!getDone()) {
                count = count + 1;
            }
            System.out.println("DONE! "+count);
        }).start();
        
        try {
            Thread.sleep(5000);
            System.out.println("changing done");
            synchronized(Sample.class) {
                done = true;
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(SampleB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private synchronized static boolean getDone() {
        return done;
    }
}
