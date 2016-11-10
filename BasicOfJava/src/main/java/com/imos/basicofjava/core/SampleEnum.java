/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.basicofjava.core;

/**
 *
 * @author alok
 */
public class SampleEnum {
    
    public static void main(String[] args) {
        System.out.println(External.BAD_REQUEST);
        System.out.println(External.BAD_REQUEST.getValue());
        System.out.println(External.BAD_REQUEST.name());
        System.out.println(External.BAD_REQUEST.ordinal());
    }
}
