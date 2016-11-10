/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.basicofjava.core;

/**
 *
 * @author alok
 */
public enum External {

    BAD_REQUEST(400L),
    
    UNAUTHORIZED(401L);

    private final long value;

    private External(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }
}
