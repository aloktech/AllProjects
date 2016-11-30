/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.thread;

/**
 *
 * @author Pintu
 */
public class ThreadSampleBooleanPrimitive {

    private static boolean running = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            long counter = 0;
            while (running) {
                counter++;
                if (counter > 10000000) {
                    running = false;
                }
            }
            System.out.println("Terminate A : " + counter + " " + System.currentTimeMillis());
        }).start();
//        Thread.sleep(1); //success
//        Thread.sleep(2); //success
//        Thread.sleep(3); //success
//        Thread.sleep(4); // success
//        Thread.sleep(5); // failure
//        running = false;
        new Thread(() -> {
            long counter = 0;
            while (running) {
                counter++;
            }
            System.out.println("Terminate B : " + counter + " " + System.currentTimeMillis());
        }).start();
        System.out.println("exit" + " " + System.currentTimeMillis());
    }
}
