/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee;

import com.chargebee.Environment;
import com.chargebee.ListResult;
import com.chargebee.Result;
import com.chargebee.models.Plan;
import com.chargebee.models.Plan.Status;
import com.chargebee.models.Plan.TrialPeriodUnit;
import java.io.BufferedWriter;
import java.io.FileWriter;
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
public class SamplePlan {

    public static void main(String[] args) throws IOException, JSONException {
        Environment.configure("imos-test", "test_dpUemkTT0qmzCF8DCi6H6PZ7owM9stWO");

//        Result result = Plan.create()
//                .id("silver")
//                .name("Silver")
//                .invoiceName("sample plan")
//                .price(5000).request();
//
//        Plan plan = result.plan();
        ListResult result = Plan.list()
                .limit(5)
                .trialPeriod().lte(14)
                .trialPeriodUnit().is(TrialPeriodUnit.DAY)
                .status().is(Status.ACTIVE).request();
        String filePath = "/home/alok/Tools/netbeans8.1_workspace/SampleChargebee/src/main/resources/chargebee/Plan.txt";
//        for (ListResult.Entry entry : result) {
//            Plan plan = entry.plan();
//            FileWriter writer = new FileWriter(filePath);
//            new JSONObject(plan.toJson()).write(writer);
//            writer.close();
////            Files.write(Paths.get(filePath), new JSONObject(plan.toJson()).toString().getBytes(), StandardOpenOption.APPEND);
//            break;
//        }
        String data = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONObject json = new JSONObject(data);
        List<String> keys = new ArrayList<>();
        Iterator<String> itr = json.keys();
        while (itr.hasNext()) {
            keys.add(itr.next());
        }
        Collections.sort(keys);
        Files.write(Paths.get(filePath), keys.toString().getBytes(), StandardOpenOption.APPEND, StandardOpenOption.WRITE);
    }

}
