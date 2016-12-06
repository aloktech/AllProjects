/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Pintu
 */
public class LogServiceTest {

    private final Logger logger = LoggerFactory.getLogger(LogServiceTest.class);

    @Test
    public void logging() {

        new LogService.LogServiceBuilder()
                .logger(logger)
                .logType(LogType.INFO)
                .eventType(EventType.CONFIGURATION)
                .build()
                .execute();
    }
}
