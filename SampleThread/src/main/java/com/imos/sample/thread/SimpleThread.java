/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.thread;

/**
 *
 * @author Alok
 */
public class SimpleThread extends Thread {

    public static void main(String[] args) {
        new SimpleThread().start();
    }

    public void start() {
        System.out.println("Start");
    }

    @Override
    public void run() {
        System.out.println("Execute thread");
    }
}
