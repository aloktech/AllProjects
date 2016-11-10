/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.dagger.sample;

import dagger.Component;

/**
 *
 * @author INVCH018
 */
@Component(modules = DripCoffeeModule.class)
public interface CoffeeShop {

    CoffeeMaker maker();
}
