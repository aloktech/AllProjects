/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.basicofjava.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author alok
 */
public class SampleJDBC {
    public static void main(String[] args) {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://0.0.0.0:3310/passportdb", "root", "abc123");
            System.out.println(con.getMetaData().getDatabaseProductName());
            
            String QueryStr = "SELECT * FROM xosuser "
                    + "WHERE email = ?";

            try (PreparedStatement statement = con.prepareCall(QueryStr)) {
                statement.setString(1, "alok.meher@mailinator.com");
                try (ResultSet resultSet = statement.executeQuery();) {
                    if (resultSet.next()) {
                        System.out.println(resultSet.getString("email"));
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SampleJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SampleJDBC.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
