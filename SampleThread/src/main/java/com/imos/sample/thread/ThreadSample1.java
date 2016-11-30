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
public class ThreadSample1 {
    private static boolean running = true;
    
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            int counter = 0;
            while(running) {
                counter++;
            }
            System.out.println(counter);
        }).start();
        Thread.sleep(3000);
        running = false;
        System.out.println("exit");
    }
}
