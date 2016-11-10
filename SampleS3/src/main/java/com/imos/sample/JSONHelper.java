/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import static com.imos.sample.S3Constant.ACCOUNT_ID;
import static com.imos.sample.S3Constant.ANALYSIS_ID;
import static com.imos.sample.S3Constant.DATA;
import static com.imos.sample.S3Constant.EVENT;
import static com.imos.sample.S3Constant.NUM_FAILED_ELEMENTS;
import static com.imos.sample.S3Constant.NUM_FAILED_RULES;
import static com.imos.sample.S3Constant.NUM_OF_ELEMENTS;
import static com.imos.sample.S3Constant.NUM_OF_RULES;
import static com.imos.sample.S3Constant.PROJECT_ID;
import static com.imos.sample.S3Constant.SIGN_IN;
import static com.imos.sample.S3Constant.SYSTEM;
import static com.imos.sample.S3Constant.TIME;
import static com.imos.sample.S3Constant.TIMESTAMP;
import static com.imos.sample.S3Constant.USER_ID;
import static com.imos.sample.S3Constant.VERSION;
import java.sql.Timestamp;
import java.util.Random;
import org.json.JSONObject;

/**
 *
 * @author alok
 */
public class JSONHelper {

    public String createSigninJSON() {

        JSONObject json = new JSONObject();

        json.put(VERSION, "1");
        json.put(TIMESTAMP, new Timestamp(System.currentTimeMillis()));

        JSONObject system = new JSONObject();
        json.put(SYSTEM, system);
        system.put(TIME, new Timestamp(System.currentTimeMillis()));
        system.put(EVENT, SIGN_IN);

        JSONObject data = new JSONObject();
        json.put(DATA, data);
        data.put(USER_ID, generateRandomValue(20));
        data.put(ACCOUNT_ID, generateRandomValue(20));

        return json.toString();
    }

    public String createAnalysisJSON() {

        JSONObject json = new JSONObject();

        json.put(VERSION, "1");
        json.put(TIMESTAMP, new Timestamp(System.currentTimeMillis()));

        JSONObject system = new JSONObject();
        json.put(SYSTEM, system);
        system.put(TIME, new Timestamp(System.currentTimeMillis()));
        system.put(EVENT, SIGN_IN);

        JSONObject data = new JSONObject();
        json.put(DATA, data);
        data.put(ANALYSIS_ID, generateRandomValue(20));
        data.put(ACCOUNT_ID, generateRandomValue(20));
        data.put(PROJECT_ID, generateRandomValue(20));

        int eleVal1 = generateRandomValue(1000), eleVal2, ruleVal1 = generateRandomValue(30), ruleVal2;
        data.put(NUM_OF_ELEMENTS, eleVal1);
        data.put(NUM_OF_RULES, ruleVal1);
        
        do {
            eleVal2 = generateRandomValue(1000);
        } while (eleVal2 > eleVal1);
        data.put(NUM_FAILED_ELEMENTS, eleVal2);
        
        do {
            ruleVal2 = generateRandomValue(1000);
        } while (ruleVal2 > ruleVal1);
        data.put(NUM_FAILED_RULES, ruleVal2);

        return json.toString();
    }

    private int generateRandomValue(int limit) {
        return new Random().nextInt(limit);
    }
}
