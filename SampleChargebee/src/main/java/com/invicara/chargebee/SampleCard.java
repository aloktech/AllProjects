/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee;

import com.chargebee.Environment;
import com.chargebee.Result;
import com.chargebee.models.Card;
import com.chargebee.models.Customer;
import com.chargebee.models.enums.Gateway;
import java.io.IOException;

/**
 *
 * @author INVCH018
 */
public class SampleCard {

    public static void main(String[] args) throws IOException {

        Environment.configure("imos-test", "test_dpUemkTT0qmzCF8DCi6H6PZ7owM9stWO");

        Result result = Card.updateCardForCustomer("cbdemo_ricky")
                .gateway(Gateway.CHARGEBEE)
                .firstName("Richard")
                .lastName("Fox")
                .number("4012888888881881")
                .expiryMonth(10)
                .expiryYear(2022)
                .cvv("999")
                .request();
        Card card = result.card();
        System.out.println(card);
    }
}
