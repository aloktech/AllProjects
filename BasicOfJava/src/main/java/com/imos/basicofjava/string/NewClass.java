/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.basicofjava.string;

/**
 *
 * @author INVCH018
 */
public class NewClass {

    public static void main(String[] args) {
        String a = "Alok";
        String b = "Alok";
//        String c = new String("Alok").intern();
        String c = new String("Alok");
        System.out.println(a.hashCode() + " : " + b.hashCode()+" : " + c.hashCode());
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(a.intern()==c.intern());
        System.out.println(a.equals(c));
        System.out.println(a.equals(b));
    }

}
