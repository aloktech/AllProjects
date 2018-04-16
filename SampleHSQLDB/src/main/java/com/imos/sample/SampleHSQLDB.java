/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Pintu
 */
public class SampleHSQLDB {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.hsqldb.jdbc.JDBCDriver");
        try (Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/sampledb"); 
                Statement statement = conn.createStatement()) {
//            statement.execute("");
        }
    }
}
