/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee.common;

import java.util.Optional;

/**
 *
 * @author alok
 * @param <T>
 */
public interface Repository<T> {

    Optional<T> create();

    Optional<T> getById(String id);

    boolean updateById(String id, String... value);

    boolean deleteById(String id);
}
