/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.abstractfactory;

/**
 *
 * @author ameher
 * @param <T>
 */
public interface IDatabase<T> extends AutoCloseable {

    public void configure();
    
    public T openConnection();
}
