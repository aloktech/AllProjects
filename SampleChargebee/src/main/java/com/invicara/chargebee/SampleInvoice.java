/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee;

import com.chargebee.Environment;
import com.chargebee.ListResult;
import com.chargebee.Result;
import com.chargebee.filters.enums.SortOrder;
import com.chargebee.models.Invoice;
import com.chargebee.models.Invoice.Status;
import java.io.IOException;

/**
 *
 * @author INVCH018
 */
public class SampleInvoice {

    public static void main(String[] args) throws IOException {
        Environment.configure("imos-test", "test_dpUemkTT0qmzCF8DCi6H6PZ7owM9stWO");

        ListResult result = Invoice.list()
                .limit(1)
                .status().is(Status.PAID)
                .total().lte(1000)
                .sortByDate(SortOrder.ASC).request();
        result.stream().forEach((entry) -> {
            Invoice invoice = entry.invoice();
            System.out.println(invoice);
        });
    }
}
