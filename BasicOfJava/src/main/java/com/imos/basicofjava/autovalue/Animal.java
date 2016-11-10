/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.basicofjava.autovalue;

import com.google.auto.value.AutoValue;

/**
 *
 * @author INVCH018
 */
//@AutoValue
//abstract class Animal {
//
//    static Animal create(String name, int numberOfLegs) {
//        // See "How do I...?" below for nested classes.
//        return new AutoValue_Animal(name, numberOfLegs);
//    }
//
//    abstract String name();
//
//    abstract int numberOfLegs();
//}

@AutoValue
public abstract class Animal {

    public abstract String name();

    public abstract int numberOfLegs();

    public static Builder builder() {
        return new AutoValue_Animal.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract Builder name(String value);

        public abstract Builder numberOfLegs(int value);

        public abstract Animal build();
    }
}
