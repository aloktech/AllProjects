/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sampleweld;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author INVCH018
 */
@Singleton
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Inject
    private SomeOtherBean injectedBean;

    @PostConstruct
    public void init() {
        System.out.println("init");
    }
    
    public void run() {
        LOGGER.debug("application initialized");
        
        injectedBean.doSomething();

    }

}
