/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.basicofjava.others;

import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author alok
 */
public final class SampleObjects {

    /**
     *
     */
    private static final int AGE = 3;

    /**
     *
     */
    private SampleObjects() {
    }

    /**
     *
     * @param args
     */
    public static void main(final String[] args) {
        config();
    }

    /**
     *
     */
    private static void config() {

        SampleClass cls = new SampleClass(AGE, "Alok");

        System.out.println(cls);
    }
}

/**
 *
 * @author alok
 */
@Getter
@Setter
@ToString
class SampleClass {

    /**
     *
     */
    private int age;
    /**
     *
     */
    private String name;

    public SampleClass(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SampleClass) {
            SampleClass cls = (SampleClass) obj;
            return Objects.equals(cls.getAge(), cls.getName());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

}
