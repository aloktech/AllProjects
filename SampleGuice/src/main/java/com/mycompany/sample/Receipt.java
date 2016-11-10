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
public class Receipt {

    public static Receipt forSystemFailure(String message) {
        return new Receipt();
    }

    public static Receipt forSuccessfulCharge(int amount) throws UnreachableException {
        return new Receipt();
    }

    public static Receipt forDeclinedCharge(String message) throws UnreachableException {
        return new Receipt();
    }
}
