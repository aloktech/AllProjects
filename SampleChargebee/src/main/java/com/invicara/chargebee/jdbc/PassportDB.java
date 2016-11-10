/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee.jdbc;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author INVCH018
 */
public final class PassportDB {

    private PassportDB() {
    }

    public static void main(String[] args) {
        String allTables = "SHOW TABLES FROM passportdb";
        String allColumns = "SELECT `COLUMN_NAME` FROM `INFORMATION_SCHEMA`.`COLUMNS` WHERE "
                + "`TABLE_SCHEMA`='%s'  AND `TABLE_NAME`='%s'";
        ResultSet result = null;
        Connection con = null;
        Statement statement = null;
        try {
            Properties properties = new Properties();
            properties.load(EmpireManageDB.class.getClassLoader().getResourceAsStream("databasepp"));
            con = DriverManager.getConnection(properties.getProperty("url"),
                    properties.getProperty("user"), properties.getProperty("password"));
            statement = con.createStatement();
            result = statement.executeQuery(allTables);
            List<String> tableNames = new ArrayList<>();
            while (result.next()) {
                tableNames.add(result.getString(1));
            }
            Files.write(Paths.get("src/main/resources/passport/passportdb.txt"), tableNames, StandardCharsets.UTF_8);
            Collections.sort(tableNames);
            for (String table : tableNames) {
                result = statement.executeQuery(String.format(allColumns, "passportdb", table));
                List<String> allColumnsOfTable = new ArrayList<>();
                while (result.next()) {
                    allColumnsOfTable.add(result.getString("COLUMN_NAME"));
                }
                Collections.sort(allColumnsOfTable);
                Files.write(Paths.get("src/main/resources/passport/" + table + ".txt"), allColumnsOfTable, StandardCharsets.UTF_8);
            }

        } catch (SQLException | IOException ex) {
            Logger.getLogger(PassportDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(PassportDB.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(PassportDB.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(PassportDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
