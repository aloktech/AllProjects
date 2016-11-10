/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.basicofjava;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author INVCH018
 */
@Setter @Getter
public class Rectangle extends Shape {
    private double height, width;

    @Override
    public double area() {
        return width * height;
    }
    
}
