/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import java.net.Socket;
import lombok.extern.log4j.Log4j2;

/**
 *
 * @author Pintu
 */
@Log4j2
public class SampleClient {

    public static void main(String[] args) {
        new SampleClient().test();
    }

    public void test() {
        log.info("Start");
        log.error("Error");
        log.error("Error",new Exception("Testing"));
        log.info("End");
    }
}
