/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Pintu
 */
@Getter
@Setter
@EqualsAndHashCode
public class ParameterPair {

    private DataType dataType;
    private Object data;

    public ParameterPair(DataType dataType, Object data) {
        this.dataType = dataType;
        this.data = data;
    }
    
}
