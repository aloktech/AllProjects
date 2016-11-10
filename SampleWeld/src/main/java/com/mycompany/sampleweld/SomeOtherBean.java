/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sampleweld;

import javax.annotation.PostConstruct;

/**
 *
 * @author INVCH018
 */
public class SomeOtherBean {

    @PostConstruct
    public void init() {
        System.out.println("init");
    }

    public void doSomething() {
        System.out.println("doSomething");
    }
}
