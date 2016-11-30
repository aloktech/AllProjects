/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.thread.chapter01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Alok
 */
public class Sample {
    
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        executorService.submit(() -> {System.out.println("In another thread from pool "+Thread.currentThread());});
        executorService.submit(() -> {System.out.println("In another thread from pool "+Thread.currentThread());});
        executorService.submit(() -> {System.out.println("In another thread from pool "+Thread.currentThread());});
        executorService.submit(() -> {System.out.println("In another thread from pool "+Thread.currentThread());});
        executorService.shutdown();
        
        Thread thread = new Thread(() -> {System.out.println("In another thread "+Thread.currentThread());});
        thread.start();
        
        System.out.println("In main "+Thread.currentThread());
    }
}
