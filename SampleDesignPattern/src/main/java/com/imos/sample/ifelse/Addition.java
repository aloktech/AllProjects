/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.ifelse;

/**
 *
 * @author Pintu
 */
public class Addition implements ICalculator<Value, Value, Exception> {

    final Value value;

    public Addition(Value value) {
        this.value = value;
    }

    @Override
    public Value calculate(Value input) throws Exception {
        return new Value();
    }

}
