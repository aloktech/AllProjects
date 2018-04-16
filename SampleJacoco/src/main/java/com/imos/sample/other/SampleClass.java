/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.other;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author Pintu
 */
@Slf4j
public class SampleClass {

    public void check(boolean test) {
        int a = 10;
        if (test) {
            log.info("Test {0}", a);
            log.info("Test");
        } else {
            log.info("No Test");
        }
    }
    
    public void checkOne(boolean test) {
        int a = 10;
        if (test) {
            log.info("Test {}", a);
            log.info("Test");
        } else {
            log.info("No Test");
        }
    }
    
    public void checkTwo(boolean test) {
        int a = 10;
        if (test) {
            log.info("Test {}", a);
            log.info("Test");
        } else {
            log.info("No Test");
        }
    }
}
