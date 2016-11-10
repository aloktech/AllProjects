/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.basicofjava;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author INVCH018
 */
public class MainClass {

    public MainClass() {
        Shape shape = new Rectangle();
        System.out.println(shape.area());
        Rectangle rect = (Rectangle) shape;
        rect.setWidth(20);
        rect.setHeight(30);
        System.out.println(shape.area());
        
        
        ConcurrentHashMap as;
        @SuppressWarnings("UseOfObsoleteCollectionType")
        Hashtable h;
        String str;
        HashMap hm;
        
        
    }
    
    public <T extends V> void test(T obj) {
        obj.testOne();
    }
    
    class V {
        void testOne() {
            System.out.println("testOne");
        }
    }
    
    class P extends V {
        @Override
        void testOne() {
            System.out.println("testTwo");
        }
    }
    
    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
        
        V v = mainClass.new P();
        mainClass.test(v);
        
        v = mainClass.new V();
        mainClass.test(v);
    }
}
