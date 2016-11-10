/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.jdbc.JdbcRealm;

/**
 *
 * @author alok
 */
public class JDBCConnection {

    public static void main(String[] args) {
        try {
            Realm myRealm = new CustomRealm();
            CredentialsMatcher customMatcher = new CustomCredentialsMatcher();
//        myRealm.setCredentialsMatcher(customMatcher);

            MysqlDataSource mysqlDS = new MysqlDataSource();
            mysqlDS.setUser("root");
            mysqlDS.setPassword("admin");
            mysqlDS.setDatabaseName("sampledb");
            mysqlDS.setPort(3306);
            mysqlDS.setUrl("localhost");

            try (Connection connection = mysqlDS.getConnection()){
                
            } catch (Exception e) {
            }
            Connection connection = mysqlDS.getConnection();
            System.out.println(connection.getMetaData().getDatabaseProductName());
            System.out.println(connection.getSchema());
            connection.close();

            JdbcRealm jdbcRealm = new JdbcRealm();
            jdbcRealm.setDataSource(mysqlDS);
        } catch (SQLException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
