/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.basicofjava.oo;

import java.util.Collection;
import java.util.List;

/**
 *
 * @author INVCH018
 * @param <T>
 */
public class Bag<T> implements BagOperation {

    Collection<? extends T> list;

    Bag(List<T> list) {
        this.list = list;
    }
    @Override
    public <T> void addItem(T obj) {
    }

    @Override
    public <T> void removeItem(T obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> Iterable<T> iterateItems() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
