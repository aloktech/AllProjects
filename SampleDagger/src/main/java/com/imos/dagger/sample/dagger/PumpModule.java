package com.imos.dagger.sample.dagger;

import dagger.Module;
import dagger.Provides;

/**
 *
 * @author INVCH018
 */
@Module(complete = false, library = true)
public class PumpModule {

    @Provides
    Pump providePump(Thermosiphon pump) {
        return pump;
    }
}
