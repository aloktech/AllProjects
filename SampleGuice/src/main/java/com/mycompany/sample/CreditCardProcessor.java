/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sample;

/**
 *
 * @author INVCH018
 */
public interface CreditCardProcessor {

    ChargeResult charge(CreditCard creditCard, int amount);
}
