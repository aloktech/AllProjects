/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.hibernate.utils;

import lombok.Getter;

/**
 *
 * @author Pintu
 */
public enum Database {
    
    CHECK_DB("checkdb"),
    SAMPLE_DB("sampledb"),
    SKILL_DB("skilldb");
    
    @Getter
    private final String name;

    private Database(String name) {
        this.name = name;
    }
}
