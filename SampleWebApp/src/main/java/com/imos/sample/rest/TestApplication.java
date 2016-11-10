/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.rest;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author alok
 */
@ApplicationPath("rest")
public class TestApplication extends Application {
    public TestApplication() {
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classesSet = new HashSet<>();
        classesSet.add(TestREST.class);
        return classesSet;
    }
    
}
