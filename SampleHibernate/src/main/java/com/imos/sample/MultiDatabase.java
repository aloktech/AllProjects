/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import com.imos.sample.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author INVCH018
 */
public class MultiDatabase {
    
    public static void main(String[] args) {
        try (Session session = HibernateUtil.openConnection("SampleDB")) {
            session.createQuery("from userdetailoto").list().stream().forEach(System.out::println);
        }
    }
}
