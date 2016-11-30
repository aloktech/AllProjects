/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import java.io.File;
import net.engio.mbassy.bus.MBassador;
import net.engio.mbassy.listener.Handler;

/**
 *
 * @author Pintu
 */
public class NewClass {

    public static void main(String[] args) {
        // Define your listener
        class SimpleFileListener {

            @Handler
            public void handle(File msg) {
                System.out.println(msg.getName());
            }

        }

// somewhere else in your code
        MBassador bus = new MBassador();
        Object listener = new SimpleFileListener();
        bus.subscribe(listener);
        bus.post(new File("/tmp/smallfile.csv")).now();
        bus.post(new File("/tmp/bigfile.csv")).asynchronously();
    }
}
