/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.basicofjava.core;

import org.json.JSONObject;

/**
 *
 * @author alok
 */
public class PerformanceCheck {
    static String key = "name";
    public static void main(String[] args) {
        
        JSONObject data = new JSONObject();
        data.put(key, "Alok");
        long startTime, val1, val2;
        for (int p = 0; p < 10; p++) {
            startTime = System.currentTimeMillis();
            for (int index = 0; index < 1000000; index++) {
                check1(data);
            }
            val1 = System.currentTimeMillis() - startTime;
            System.out.println(val1);
            
            startTime = System.currentTimeMillis();
            for (int index = 0; index < 1000000; index++) {
                check2(data);
            }
            val2 = System.currentTimeMillis() - startTime;
            System.out.println(val2);
            System.out.println("");
        }

    }
    
    static void check1(JSONObject data) {
        data.getString(key);
    }
    
    static void check2(JSONObject data) {
        data.getString("name");
    }
}
