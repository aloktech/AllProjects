/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.basicofjava.validation;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * @author alok
 */
public class SampleValidation {

    public static void main(String[] args) {
        Person person = new Person();
        person.setFirstName("Alok");

        System.out.println(person);

        validate(person);
    }

    public static <T extends Object> void validate(T object) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> valRes = validator.validate(object);
        if (!valRes.isEmpty()) {
            StringBuilder sb = new StringBuilder("Validation failed for: ");
            

            for (ConstraintViolation<T> fail : valRes) {
                sb.append("\n  ").append(fail.getMessage());
            }
            throw new IllegalArgumentException(sb.toString());
        }
    }// validate()
}
