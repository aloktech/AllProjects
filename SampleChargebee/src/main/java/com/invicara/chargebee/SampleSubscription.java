/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee;

import com.chargebee.Environment;
import com.chargebee.ListResult;
import com.chargebee.filters.enums.SortOrder;
import com.chargebee.models.Subscription;
import com.chargebee.models.Subscription.Status;
import java.io.IOException;

/**
 *
 * @author INVCH018
 */
public class SampleSubscription {

    public static void main(String[] args) throws IOException {

        Environment.configure("imos-test", "test_dpUemkTT0qmzCF8DCi6H6PZ7owM9stWO");

        ListResult result = Subscription.list()
                .planId().is("free-trial")
                .status().is(Status.IN_TRIAL)
                .sortByCreatedAt(SortOrder.ASC).request();
        result.stream().forEach(System.out::println);
    }
}

