/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.basicofjava.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author alok
 */
public class SampleRegex {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("a*");
        Matcher matcher = pattern.matcher("abaa*sdaa");

        System.out.println("# 1");
        if (matcher.find()) {
            System.out.println("Found");
        }
        if (matcher.matches()) {
            System.out.println("Matches");
        }
        
        System.out.println("# 2");
        matcher = pattern.matcher("aa");
        if (matcher.matches()) {
            System.out.println("Matches");
        }
        System.out.println(matcher.pattern().pattern());
        
        System.out.println("# 3");
        pattern = Pattern.compile("\\w*.json");
        matcher = pattern.matcher("dd.json");
        if (matcher.matches()) {
            System.out.println("Matches");
        }
        System.out.println(matcher.pattern().pattern());
        
//        System.out.println("a*".contains("a"));
//        System.out.println("a*".contains("*"));
//        System.out.println("a*".contains("\\*"));
//        System.out.println("a*".contains("\\\\*"));
//        System.out.println("a*".contains("/*"));
    }
}
