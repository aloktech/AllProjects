/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 *
 * @author Pintu
 */
public class SampleTestNG {

    public SampleTestNG() {
    }

    @DataProvider(name = "data")
    public Object[][] sampleData() {
        return new Object[][]{
            {"Alok", 38},
            {"Gayatri", 32}
        };
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @BeforeTest
    public void setUp() {
    }

    @AfterTest
    public void tearDown() {
    }

    @Test(dataProvider = "data")
    public void hello(String name, int age) {
        System.out.println(name + " : " + age);
        
        Assert.assertNotNull(name, "Should not be null");
    }
    
    @Test(dataProvider = "data")
    public void hello1(String name, int age) {
        System.out.println(name + " : " + age);
        SoftAssert sa = new SoftAssert();
        sa.assertNotNull(name, "Should not be null");
        sa.assertTrue(age > 30);
        sa.assertAll();
    }
}
