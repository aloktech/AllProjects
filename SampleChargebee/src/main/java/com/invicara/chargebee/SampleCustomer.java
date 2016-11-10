/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee;

import com.chargebee.Environment;
import com.chargebee.ListResult;
import com.chargebee.filters.enums.SortOrder;
import com.chargebee.models.Card;
import com.chargebee.models.Customer;
import java.io.IOException;

/**
 *
 * @author INVCH018
 */
public class SampleCustomer {

    public static void main(String[] args) throws IOException {

        Environment.configure("imos-test", "test_dpUemkTT0qmzCF8DCi6H6PZ7owM9stWO");

        ListResult result = Customer.list()
                .limit(1)
                //                .firstName().is("John")
                //                .lastName().isNot("Doe")
                //                .email().is("john@test.com")
                .sortByCreatedAt(SortOrder.ASC)
                .request();
        result.stream()
//                .map((entry) -> {
//                    Customer customer = entry.customer();
//                    System.out.println("Customer");
//                    System.out.println(customer);
//                    return entry;
//                })
                .forEach((entry) -> {
                    Customer customer = entry.customer();
                    System.out.println("Customer Id");
                    System.out.println(customer);
//                    Card card = entry.card();
//                    System.out.println("Card");
//                    System.out.println(card);
                });
    }
}
