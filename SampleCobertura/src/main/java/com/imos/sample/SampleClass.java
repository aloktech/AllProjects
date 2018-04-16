/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

/**
 *
 * @author Pintu
 */
public class SampleClass {

    public  int counter;

//    private SampleClass() {
//    }

    public  String foo(boolean b) {
        int i = 0;
        if (b) {
//            i++;
            return "OK";
        }

        return "FAIL";
    }

    public  void count(int value) {
        if (value < 10) {
            counter++;
        }
    }

    public  int add(int a, int b) {
        int value = a + b;
        return value;
    }

    public  int minus(int a, int b) {
        int value = a - b;
        return value;
    }
}
