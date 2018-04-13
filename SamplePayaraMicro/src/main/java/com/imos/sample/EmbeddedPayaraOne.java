/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import fish.payara.micro.BootstrapException;
import fish.payara.micro.PayaraMicro;

/**
 *
 * @author Pintu
 */
public class EmbeddedPayaraOne {

    public static void main(String[] args) {
        try {
            PayaraMicro instance = PayaraMicro.getInstance();
            instance.setHttpAutoBind(true)
                    .setHttpPort(8091)
                    .setInstanceName("One")
                    .setInstanceGroup("ample")
                    .setUserLogFile("./PayaraMicro.log")
                    .bootStrap();
//            instance.shutdown();
        } catch (BootstrapException e) {
            e.printStackTrace();
        }
    }
}
