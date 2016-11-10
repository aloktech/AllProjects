/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.util;

import org.aeonbits.owner.Config;

/**
 *
 * @author alok
 */
public interface TestDefault extends Config {

    String driver();

    String user();

    String password();

    String protocol();

    String database();

    int port();
}
