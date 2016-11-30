/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Pintu
 */
@Getter
@Setter
public class DatabaseInfo {

    private String protocol;
    private String subProtocol;
    private String host;
    private int port;
    private String databaseName;
    private String optional;
    private String userName;
    private String password;
    private String driver;
    private String url;
}
