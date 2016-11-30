/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import lombok.Getter;

/**
 *
 * @author Pintu
 */
public enum EventType {

    OPEN_CONNECTION("Open Connection"),
    CLOSE_CONNECTION("Close Connection"),
    OPEN_PREPARESTATEMENT("Open PrepareStatement"),
    CLOSE_PREPARESTATEMENT("Close PrepareStatement"),
    CONFIGURATION("Configuration"),
    ADD("Add"),
    GET("Get"),
    UPDATE("Update"),
    ROLLBACK("Rollback"),
    DELETE("Delete");
    
    @Getter
    private final String name;

    private EventType(String name) {
        this.name = name;
    }
}
