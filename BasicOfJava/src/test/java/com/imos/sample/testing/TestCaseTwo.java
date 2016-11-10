package com.imos.sample.testing;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author INVCH018
 */
public class TestCaseTwo {

    public TestCaseTwo() {
    }

    @BeforeClass
    public static void basicSetUp() {
        TestCaseOne one = new TestCaseOne();
        one.setUp();
        System.out.println("TestCaseTwo setUp");
    }
    
    @Before
    public void setUp() {
        System.out.println("TestCaseTwo setUp");
    }

    @Test
    public void methodOne() {
        System.out.println("methodOne");
    }

    @Test
    public void methodTwo() {
        System.out.println("methodTwo");
    }

}
