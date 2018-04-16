package com.imos.sample.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.imos.sample.SampleClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Pintu
 */
public class SampleTest {

    private static SampleClass cls;
    
    @BeforeClass
    public static void setUp() {
        cls = new SampleClass();
    }
    
    @Test
    public void testOne() {
        cls.check(true);
    }

    @Test
    public void testTwo() {
        cls.checkOne(12);
    }

    @Test
    public void testThree() {
        cls.checkTwo(false);
    }

    @Test
    public void testFour() {
        cls.checkOne(8);
    }
}
