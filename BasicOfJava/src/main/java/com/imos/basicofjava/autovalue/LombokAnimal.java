package com.imos.basicofjava.autovalue;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author INVCH018
 */
@Builder
@Data
public class LombokAnimal {
    private String name;

    private int numberOfLegs;
    
    public static class LombokAnimalBuilder {

        public LombokAnimalBuilder() {
        }
    }
}
