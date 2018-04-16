/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.database.test;

import com.imos.sample.database.util.QueryBuilder;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Pintu
 */
public class QueryBuilderTest {

    private QueryBuilder queryBuilder;

    @AfterEach
    public void nextTest() {
        System.out.println(queryBuilder.build());
        System.out.println(queryBuilder.generateQuery());
    }

    @AfterAll
    public static void testComplete() {
        QueryBuilder.writeQueriesToFile();
    }

    @Test
    public void sqlTest() {
        queryBuilder = new QueryBuilder()
                .addQuery("select * ")
                .addQuery("from person p")
                .addQuery("order by p.pd_id.first_name");
        queryBuilder.addQueryName("sqlTest");
        System.out.println("sqlTest");
    }

    @Test
    public void intTest() {
        queryBuilder = new QueryBuilder()
                .addQuery("from Person p")
                .addQuery("where p.id =")
                .addQuery(1);
        queryBuilder.addQueryName("intTest");
        System.out.println("intTest");
    }

    @Test
    public void longTest() {
        queryBuilder = new QueryBuilder()
                .addQuery("from Person p")
                .addQuery("where p.id =")
                .addQuery(1L);
        queryBuilder.addQueryName("longTest");
        System.out.println("longTest");
    }

    @Test
    public void floatTest() {
        queryBuilder = new QueryBuilder()
                .addQuery("from Person p")
                .addQuery("where p.id =")
                .addQuery(1.0F);
        queryBuilder.addQueryName("floatTest");
        System.out.println("floatTest");
    }

    @Test
    public void doubleTest() {
        queryBuilder = new QueryBuilder()
                .addQuery("from Person p")
                .addQuery("where p.id =")
                .addQuery(1.0D);
        queryBuilder.addQueryName("doubleTest");
        System.out.println("doubleTest");
    }

    @Test
    public void stringTest() {
        queryBuilder = new QueryBuilder()
                .addQuery("from Person p")
                .addQuery("where p.id =")
                .addQuery("hello");
        queryBuilder.addQueryName("stringTest");
        System.out.println("stringTest");
    }

    @Test
    public void bigIntegerTest() {
        queryBuilder = new QueryBuilder()
                .addQuery("from Person p")
                .addQuery("where p.id =")
                .addQuery(new BigInteger("1"));
        queryBuilder.addQueryName("bigIntegerTest");
        System.out.println("bigIntegerTest");
    }

    @Test
    public void bigDecimalTest() {
        queryBuilder = new QueryBuilder()
                .addQuery("from Person p")
                .addQuery("where p.id =")
                .addQuery(new BigDecimal("1.00"));
        queryBuilder.addQueryName("bigDecimalTest");
        System.out.println("bigDecimalTest");
    }
}
