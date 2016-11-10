/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.dagger.sample;

import dagger.Module;
import dagger.Provides;

/**
 *
 * @author INVCH018
 */
@Module
public class DripCoffeeModule {

    @Provides
    static Heater provideHeater() {
        return new ElectricHeater();
    }

    @Provides
    static Pump providePump(Thermosiphon pump) {
        return pump;
    }
}
