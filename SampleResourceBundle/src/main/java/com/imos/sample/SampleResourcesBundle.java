/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author ameher
 */
public class SampleResourcesBundle {
    
    static ResourceBundle bundle = ResourceBundle.getBundle("default");
    
    public static void main(String[] args) {
        bundle = ResourceBundle.getBundle("default");
        System.out.println(bundle.getLocale().getDisplayCountry() + " : " +bundle.getString("test"));
        
        bundle = ResourceBundle.getBundle("default", Locale.FRENCH);
        System.out.println(bundle.getLocale().getDisplayCountry() + " : " +bundle.getString("test"));
        
        bundle = ResourceBundle.getBundle("default", Locale.GERMAN);
        System.out.println(bundle.getLocale().getDisplayCountry() + " : " +bundle.getString("test"));
        
        bundle = ResourceBundle.getBundle("default", Locale.CANADA);
        System.out.println(bundle.getLocale().getDisplayCountry() + " : " +bundle.getString("test"));
        
        
        
    }
}
