/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.basicofjava.bit;

/**
 *
 * @author INVCH018
 */
public class BitSample {

    public static void main(String[] args) {
        int p = 1, q;
        System.out.println(Integer.toBinaryString(p) + " : " + p);
        q = p << 1;
        System.out.println(Integer.toBinaryString(q) + " : " + q);
        int a = 11;
        int b = q;
        int c = a ^ b;
        System.out.println("a "+Integer.toBinaryString(a) + " : " + a);
        System.out.println("b "+Integer.toBinaryString(b) + " : " + b);
        System.out.println("c "+Integer.toBinaryString(c) + " : " + c);
        q = 5;
        System.out.println(Integer.toBinaryString(q) + " : " + q);
        q = q >> 1;
        System.out.println(Integer.toBinaryString(q) + " : " + q);
//        q = p | q;
//        System.out.println(Integer.toBinaryString(q) + " : " + q);
//        q = q << 1;
//        System.out.println(Integer.toBinaryString(q) + " : " + q);
//        q = q << 1;
//        System.out.println(Integer.toBinaryString(q) + " : " + q);
//        
//        int N = 5;
//        String data = Integer.toBinaryString(N);
//        System.out.println(N + " : " + data);
    }
}
