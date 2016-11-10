/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.basicofjava.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MarkerFactory;



/**
 *
 * @author alok
 */
public class SampleLogging {
    
    final static Logger LOGGER = LoggerFactory.getLogger(SampleLogging.class);
    
    public static void main(String[] args) {
        
        LOGGER.info("Logging1");
        LOGGER.isInfoEnabled(MarkerFactory.getMarker("Marker"));
        LOGGER.info(MarkerFactory.getMarker("Marker"), "Logging2");
        LOGGER.info("{0}", "Logging3");
    }
}
