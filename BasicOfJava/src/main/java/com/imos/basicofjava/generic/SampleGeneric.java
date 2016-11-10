/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.basicofjava.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author INVCH018
 */
public class SampleGeneric {

    public static void main(String[] args) {
        List<String> listStr = test(new String[]{"Alok", "Pintu"});
        System.out.println(listStr.size());
        List<Integer> listInt = test(new Integer[]{1, 0});
        System.out.println(listInt.size());
//        test(String.class);̥
    }

    static <T> List<T> test(T[] array) {
        List<T> list = new ArrayList<>();
        list.addAll(Arrays.asList(array));
        System.out.println("test");
        System.out.println(array);
        return list;
    }
}
