/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.dagger.sample;

import javax.inject.Inject;

/**
 *
 * @author INVCH018
 */
public class CoffeeMaker {

    @Inject
    Heater heater;
    @Inject
    Pump pump;

}
