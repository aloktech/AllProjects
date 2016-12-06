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
