/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

/**
 *
 * @author Pintu
 * @param <M>
 * @param <E>
 */
@FunctionalInterface
public interface ExceptionFunction<M, E extends Exception> {

    Object accept(M m) throws E;
}
