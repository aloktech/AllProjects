package com.mycompany.sampledagger;

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
