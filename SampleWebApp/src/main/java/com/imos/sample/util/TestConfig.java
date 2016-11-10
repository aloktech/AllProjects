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
public interface TestConfig extends Config {

    @Key("mysql.user")
    String user();
    
    @Key("mysql.password")
    String password();
    
    @Key("mysql.protocol")
    String protocol();
    
    @Key("mysql.database")
    String database();
    
    @Key("mysql.host")
    String host();
    
    @Key("mysql.driver")
    String driver();

    @Key("mysql.port")
    int port();
}
