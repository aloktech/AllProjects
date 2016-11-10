/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee;

import com.chargebee.Environment;
import com.chargebee.Result;
import com.chargebee.models.Estimate;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author INVCH018
 */
public class SampleEstimate {

    public static void main(String[] args) throws IOException, JSONException {

        Environment.configure("imos-test", "test_dpUemkTT0qmzCF8DCi6H6PZ7owM9stWO");

        Result result = Estimate.createSubscription()
                .subscriptionPlanId("cbdemo_hustle")
                .billingAddressLine1("PO Box 9999")
                .billingAddressCity("Walnut")
                .billingAddressZip("91789")
                .billingAddressCountry("US").request();
        Estimate estimate = result.estimate();
        System.out.println(estimate);
        
//        String filePath = "/home/alok/Tools/netbeans8.1_workspace/SampleChargebee/src/main/resources/chargebee/next_invoice_estimate.txt";
//        String data = new String(Files.readAllBytes(Paths.get(filePath)));
//        JSONObject json = new JSONObject(data);
//        List<String> keys = new ArrayList<>();
//        Iterator<String> itr = json.keys();
//        while (itr.hasNext()) {
//            keys.add(itr.next());
//        }
//        Collections.sort(keys);
//        Files.write(Paths.get(filePath), keys.toString().getBytes(), StandardOpenOption.APPEND, StandardOpenOption.WRITE);
    }
}
