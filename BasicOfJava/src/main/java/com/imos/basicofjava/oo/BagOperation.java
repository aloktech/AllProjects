/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.basicofjava.oo;

/**
 *
 * @author INVCH018
 */
public interface BagOperation {

    <T> void addItem(T obj);

    <T> void removeItem(T obj);

    <T> Iterable<T> iterateItems();
}
