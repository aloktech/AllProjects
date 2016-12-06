package com.imos.sample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Pintu
 */
public class JdbcServiceTest {

    @BeforeClass
    public static void setUp() {
        JdbcService.INSTANCE.configure(DatabaseConfiguration.getDatabaseInfo("mysql"));

        JdbcService.INSTANCE.openConnection();
    }

    @AfterClass
    public static void tearDown() {

        JdbcService.INSTANCE.closeConnection();
    }

    @Test
    public void insert() {
        List<ParameterPair> parameterPairs = new ArrayList<>();
        parameterPairs.add(new ParameterPair(DataType.LONG, JdbcService.INSTANCE.nextIndex()));
        parameterPairs.add(new ParameterPair(DataType.STRING, "Pintu"));
        parameterPairs.add(new ParameterPair(DataType.INTEGER, 38));
        JdbcService.INSTANCE.add("INSERT INTO user (id, name, age) VALUES(?, ?, ?)", parameterPairs);
    }

    @Test
    public void select() {
        List<DataType> dataTypes = new ArrayList<>();
        dataTypes.add(DataType.LONG);
        dataTypes.add(DataType.STRING);
        dataTypes.add(DataType.INTEGER);
        Object result = JdbcService.INSTANCE.executeQuery("SELECT * FROM user", new ArrayList<>(), dataTypes);
        if (result instanceof Collection) {
            List results = (List) result;
            for (int index = 0, size = results.size(); index < size; index++) {
                System.out.println(results.get(index));
            }
        }
    }
    
    @Test
    public void delete() {
         List<ParameterPair> parameterPairs = new ArrayList<>();
        parameterPairs.add(new ParameterPair(DataType.LONG, 11L));
        
        JdbcService.INSTANCE.delete("DELETE FROM user WHERE id = ?", parameterPairs);
    }

    @Test
    public void update() {
        List<ParameterPair> parameterPairs = new ArrayList<>();
        parameterPairs.add(new ParameterPair(DataType.STRING, "Alok"));
        parameterPairs.add(new ParameterPair(DataType.LONG, 6L));

        JdbcService.INSTANCE.update("UPDATE user SET name = ? WHERE id = ?", parameterPairs);

        List<DataType> dataTypes = new ArrayList<>();
        dataTypes.add(DataType.LONG);
        dataTypes.add(DataType.STRING);
        dataTypes.add(DataType.INTEGER);

        parameterPairs = new ArrayList<>();
        parameterPairs.add(new ParameterPair(DataType.LONG, 6L));

        Object result = JdbcService.INSTANCE.executeQuery("SELECT * FROM user WHERE id = ?", parameterPairs, dataTypes);
        if (result instanceof Collection) {
            List results = (List) result;
            for (int index = 0, size = results.size(); index < size; index++) {
                System.out.println(results.get(index));
            }
        }
    }
}
