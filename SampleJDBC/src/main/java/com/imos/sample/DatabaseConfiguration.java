/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import java.util.ResourceBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Pintu
 */
public class DatabaseConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseConfiguration.class);

    public static DatabaseInfo getDatabaseInfo(String fileName) {
        
        ResourceBundle bundle = ResourceBundle.getBundle(fileName);
        DatabaseInfo databaseInfo = new DatabaseInfo();
        
        LogService logService = new LogService.LogServiceBuilder()
                .logger(LOGGER)
                .eventType(EventType.DATABASE_CONFIGURATION)
                .build();
        
        try {
        
            databaseInfo.setDriver(bundle.getString("mysql.driver"));
            databaseInfo.setProtocol(bundle.getString("mysql.protocol"));
            databaseInfo.setSubProtocol(bundle.getString("mysql.sub.protocol"));
            databaseInfo.setHost(bundle.getString("mysql.host"));
            databaseInfo.setPort(Integer.parseInt(bundle.getString("mysql.port")));
            databaseInfo.setDatabaseName(bundle.getString("mysql.database"));
            databaseInfo.setOptional(bundle.getString("mysql.optional"));
            databaseInfo.setUserName(bundle.getString("mysql.user"));
            databaseInfo.setPassword(bundle.getString("mysql.password"));

            logService.setLogType(LogType.INFO);
        } catch (Exception e) {
            logService.setLogType(LogType.ERROR);
        } finally {
            logService.execute();
        }

        return databaseInfo;
    }
}
