/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import com.imos.sample.model.HGroup;
import com.imos.sample.model.HPerson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author Pintu
 */
public class HibernateHSQLDB {

    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        try {
            setUp();
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();
                HGroup group = new HGroup();
                HPerson person = new HPerson();
                group.getPersons().add(person);
                person = new HPerson();
                group.getPersons().add(person);
                session.persist(group);
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            shutdown();
        }
    }

    protected static void setUp() throws Exception {
        // A SessionFactory is set up once for an application!
        registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    protected static void shutdown() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
