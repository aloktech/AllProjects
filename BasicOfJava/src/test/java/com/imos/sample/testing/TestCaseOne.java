package com.imos.sample.testing;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author INVCH018
 */
public class TestCaseOne {

    public TestCaseOne() {
    }

    @Before
    public void setUp() {
        System.out.println("TestCaseOne setUp");
    }
    
    @After
    public void setDown() {
        System.out.println("TestCaseOne setDown");
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
