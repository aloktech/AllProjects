/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee.test;

import com.chargebee.Environment;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.BeforeClass;

/**
 *
 * @author alok
 * @param <T>
 */
public abstract class AbstractTest<T> {

    protected static Injector injector;
    protected T instance;

    @BeforeClass
    public static void setUp() {
        injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {

            }
        });
        Environment.configure("imos-test", "test_dpUemkTT0qmzCF8DCi6H6PZ7owM9stWO");
    }

    public abstract void create();

    public abstract void getById();

    public abstract void update();

    public abstract void delete();
}
