/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

/**
 *
 * @author Pintu
 */
public class SampleLogger {

    private static final Logger LOGGER = LogManager.getLogger(SampleLogger.class);
    private static final Marker SAMPLE = MarkerManager.getMarker("SAMPLE");

    public static void main(String[] args) {
        LOGGER.info(SAMPLE, "Start");
        LOGGER.info("Start");
        LOGGER.trace("TRACE");
        LOGGER.debug("DEBUG");
        LOGGER.info("INFO");
        LOGGER.error(SAMPLE, "ERROR", new Exception("testing"));
        LOGGER.fatal("FATAL", new Exception("testing"));
        LOGGER.info("End");
        LOGGER.info(SAMPLE, "End");
    }
}
