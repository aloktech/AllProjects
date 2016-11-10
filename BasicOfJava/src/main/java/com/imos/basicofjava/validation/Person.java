/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.basicofjava.validation;

import java.util.Date;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author alok
 */
@Data
@ToString(exclude = {"dateOfJoin"})
public class Person {
    
    @NotNull
    @Size(min = 5, max = 32)
    private String firstName;
    
    @NotNull
    @Size(min = 5, max = 32)
    private String lastName;
    
    @NotNull
    @Past
    private Date dateOfJoin;
    
    @DecimalMin("40")
    @DecimalMax("100")
    @Digits(integer = 3, fraction = 2)
    private double height;
    
    @Digits(integer = 3, fraction = 2)
    private double weight;
}
