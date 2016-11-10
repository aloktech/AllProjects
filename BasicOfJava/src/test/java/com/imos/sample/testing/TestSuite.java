package com.imos.sample.testing;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author INVCH018
 */
@RunWith(Suite.class)
//@Suite.SuiteClasses({TestCaseOne.class, TestCaseTwo.class, TestcaseThree.class})
@Suite.SuiteClasses({TestCaseOne.class, TestcaseThree.class, TestCaseTwo.class})
public class TestSuite {

    public TestSuite() {
        System.out.println("TestSuite executing");
    }

}
