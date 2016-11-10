/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee;

import com.chargebee.Environment;
import com.chargebee.ListResult;
import com.chargebee.models.Transaction;
import java.io.IOException;

/**
 *
 * @author INVCH018
 */
public class SampleTransaction {

    public static void main(String[] args) throws IOException {

        Environment.configure("imos-test", "test_dpUemkTT0qmzCF8DCi6H6PZ7owM9stWO");

        ListResult result;
//        result = Transaction.list()
//                .limit(0)
//                .paymentMethod().is(PaymentMethod.CARD)
//                .status().is(Status.SUCCESS)
//                .sortByDate(SortOrder.ASC).request();
//        result.stream().map((entry) -> entry.transaction()).forEach((transaction) -> {
//            System.out.println(transaction);
//        });

        result = Transaction.paymentsForInvoice("7").request();
        for (ListResult.Entry entry : result) {
            Transaction transaction = entry.transaction();
            System.out.println(transaction);
        }
    }

}
