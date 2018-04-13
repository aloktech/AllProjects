/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.test;

import com.imos.sample.MathClass;
import org.junit.Assert;
import org.junit.Test;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;

/**
 *
 * @author Pintu
 */
public class ClassTest {
    
//    @Test
//    public void test1() {
//        Assertions.assertEquals(0, MathClass.fabonacci(0));
//        Assertions.assertEquals(1, MathClass.fabonacci(1));
//        Assertions.assertEquals(1, MathClass.fabonacci(2));
//        Assertions.assertEquals(2, MathClass.fabonacci(3));
//        Assertions.assertEquals(3, MathClass.fabonacci(4));
//    }
    
    @Test
    public void test1() {
        Assert.assertEquals(0, MathClass.fabonacci(-1));
        System.out.println("");
        Assert.assertEquals(0, MathClass.fabonacci(0));
        System.out.println("");
        Assert.assertEquals(1, MathClass.fabonacci(1));
        System.out.println("");
        Assert.assertEquals(1, MathClass.fabonacci(2));
        System.out.println("");
        Assert.assertEquals(2, MathClass.fabonacci(3));
        System.out.println("");
        Assert.assertEquals(3, MathClass.fabonacci(4));
        System.out.println("");
        Assert.assertEquals(5, MathClass.fabonacci(5));
        System.out.println("");
        Assert.assertEquals(8, MathClass.fabonacci(6));
    }
}
