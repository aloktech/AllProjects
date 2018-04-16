/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import com.imos.sample.model.SampleUser;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pintu
 */
public class MainFile {
    
    public static void main(String[] args) {
        new MainFile();
    }

    public MainFile() {
        
        SampleUser user = new SampleUser();
        
        System.out.println(user);
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb;useSSL=false", "root", "root");
            DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root", "root");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MainFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
