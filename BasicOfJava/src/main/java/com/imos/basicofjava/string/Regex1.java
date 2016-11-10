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
 * @author INVCH018
 */
public class Regex1 {

    public static void main(String[] args) {
        String str = "Danny Doo, Flat no 502, Big Apartment, Wide Road, Near Huge Milestone, Hugo - city 56010, Ph:9876543210, Email:danny@myworld.com. Maggi Myer, "
                + "Post bag no 52, Big bank post office, Big bank city 56000, ph:9876501234, Email:maggi07@myuniverse.co.in.";
        Pattern pattern = Pattern.compile("\\w+");
        pattern = Pattern.compile("\\d{5}");
        pattern = Pattern.compile("\\D\\d{5}\\D");
        pattern = Pattern.compile("\\w+@\\w+(\\.\\w+)+");
        pattern = Pattern.compile("(\\D)(\\d{3})(\\d{7})(\\D)");
        Matcher matcher = pattern.matcher(str);
//        while (matcher.find()) {
//            System.out.println(matcher.group());
//        }
        String newStr = matcher.replaceAll("$1$2-$3$4");
        System.out.println(newStr);
    }
}
