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
public final class MathClass {

    private MathClass(){}
    
    public static int fabonacci(int value) {
        if (value <= 0) {
            return 0;
        } else if (value < 2) {
            return 1;
        } else {
            return fabonacci(value - 1) + fabonacci(value - 2);
        }
    }
}
