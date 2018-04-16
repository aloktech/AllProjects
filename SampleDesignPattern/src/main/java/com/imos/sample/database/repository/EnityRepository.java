/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.database.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Pintu
 */
public class EnityRepository {

    private SessionFactory sessionFactory;
    private Session session;

    public void execute() {
        try {
            sessionFactory.openSession();
        } catch (Exception e) {
        } finally {
            session.close();
        }
    }
}
