/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.ifelse;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Pintu
 */
public class MainClass {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        ICalculator<Value, Value, Exception> addition = new Addition(new Value());
        Map<String, ICalculator<Value, Value, Exception>> map = new HashMap<>();
        map.put("+", addition);
        map.put("add", addition);

        System.out.println(map.get("+").calculate(new Value()));
        System.out.println(map.get("add").calculate(new Value()));
    }
}
