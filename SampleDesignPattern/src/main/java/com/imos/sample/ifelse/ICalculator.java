/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.ifelse;

/**
 *
 * @author Pintu
 * @param <O>
 * @param <I>
 * @param <E>
 */
public interface ICalculator<O extends IEntity, I extends IEntity, E extends Exception> {

    O calculate(I input) throws E;
}
