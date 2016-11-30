/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.hibernate.dto;

import java.io.Serializable;
import lombok.Getter;

/**
 *
 * @author Alok
 */
public enum AddressType implements Serializable {
    
    RESIDENT(1),
    OFFICE(2),
    PERMANENT(3);
    
    @Getter
    private final int code;

    AddressType(int code) {
        this.code = code;
    }
}
