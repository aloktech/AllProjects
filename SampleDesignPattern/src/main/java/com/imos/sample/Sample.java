/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

/**
 *
 * @author Pintu
 */
public class Sample {

    public static void main(String[] args) {
        InterfaceA interfaceA = new ClassA();
        show(interfaceA);

        interfaceA = new ClassB();
        show(interfaceA);

        InterfaceB interfaceB = new ClassB();
        show(interfaceB);
    }

    static void show(InterfaceA interfaceA) {
        if (interfaceA instanceof InterfaceB) {
            InterfaceB interfaceB = (InterfaceB) interfaceA;
            interfaceB.showB();
        } else {
            interfaceA.showA();
        }
    }
}
