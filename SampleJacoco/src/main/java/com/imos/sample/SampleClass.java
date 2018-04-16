/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author Pintu
 */
@Slf4j
public class SampleClass {

    public void check(boolean test) {
        int a = 0;
        if (test) {
            log.info("Test {}", a);
            log.info("Test");
        } else {
            log.info("No Test");
        }
    }

    public void checkOne(int a) {
        if (a > 10) {
            if (a < 100) {
                log.info("Test {}", a);
                if (a > 20) {
                    log.info("Test {}", a);
                } else {
                    log.info("Test {}", a);
                }
            } else {
                log.info("Test");
            }
        } else {
            log.info("No Test");
        }
    }

    public void checkTwo(boolean test) {
        int a = 0;
        if (test) {
            log.info("Test {}", a);
            log.info("Test");
        } else {
            log.info("No Test");
        }
        if (test) {
            log.info("Test {}", a);
            log.info("Test");
        } else {
            log.info("No Test");
        }
    }
}
