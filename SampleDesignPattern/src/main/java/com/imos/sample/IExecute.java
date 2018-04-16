/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

/**
 *
 * @author Pintu
 * @param <I>
 * @param <O>
 */
public interface IExecute<I, O> {

    void configure();

    O execute(I input);
}
