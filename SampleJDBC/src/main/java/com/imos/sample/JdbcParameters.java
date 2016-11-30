/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

/**
 *
 * @author Pintu
 */
public class JdbcParameters {

    private DataType dataType;
    @Getter
    private final List<ParameterPair> parameters = new ArrayList<>();

    public JdbcParameters setValue(Object data) {
        parameters.add(new ParameterPair(dataType, data));
        return this;
    }

    public JdbcParameters setDataType(DataType dt) {
        this.dataType = dt;
        return this;
    }
}
