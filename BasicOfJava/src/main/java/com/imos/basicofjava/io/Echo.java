/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.basicofjava.io;

import java.io.Console;

/**
 *
 * @author INVCH018
 */
// simple implementation of Echo command
public class Echo {

    public static void main(String[] args) {
// get the System console object
        Console console = System.console();
        if (console == null) {
            System.err.println("Cannot retrive console object - are you running your application from an IDE? Exiting the application ... ");
            System.exit(0); // terminate the application
        }
// read a line and print it through printf
        console.printf(console.readLine());
    }
}
