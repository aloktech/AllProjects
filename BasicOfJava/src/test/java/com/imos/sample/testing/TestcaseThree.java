package com.imos.sample.testing;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author INVCH018
 */
public class TestcaseThree {

    public TestcaseThree() {
    }

    @Before
    public void setUp() {
        System.out.println("TestCaseThree setUp");
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
