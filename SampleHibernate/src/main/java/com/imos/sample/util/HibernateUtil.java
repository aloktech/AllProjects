/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.util;

import java.util.List;
import lombok.extern.java.Log;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author INVCH018
 */
@Log
public class HibernateUtil {

    public static SessionFactory sessionFactory;
    public static SessionFactory sessionFactorySampleDB;
    public static SessionFactory sessionFactorySkillDB;
    public static Session session;
    public static String database;

    static {
        sessionFactory = configure();
    }

    private static SessionFactory configure() throws HibernateException {
        try {
            Configuration configuration;
//            Configuration configuration = new Configuration()l̥
////                    .addAnnotatedClass(Person.class)
////                    .addAnnotatedClass(Address.class)
//                    .addAnnotatedClass(UserDetailOTO.class)
//                    .addAnnotatedClass(UserDetailOTM.class)
//                    .addAnnotatedClass(UserDetailMTM.class)
//                    .addAnnotatedClass(VehicleOTO.class)
//                    .addAnnotatedClass(VehicleOTM.class)
//                    .addAnnotatedClass(VehicleMTM.class)
//                    //                    .setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
//                    .setProperty("hibernate.connection.username", "root")
//                    .setProperty("hibernate.connection.password", "invicara")
//                    .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/sampledb?autoReconnect=true&useSSL=false")
//                    .setProperty("hibernate.connection.pool_size", "1")
//                    .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
//                    .setProperty("hibernate.show_sql", "true")
//                    .setProperty("hibernate.hbm2ddl.auto", "update");
//
//            sessionFactory = configuration.buildSessionFactory();
            configuration = new Configuration()
                    .configure("hibernate_sampledb.cfg.xml");

            sessionFactorySampleDB = configuration.buildSessionFactory();

//            configuration = new Configuration()
//                    .configure("hibernate_skilldb.cfg.xml");
//
//            sessionFactorySkillDB = configuration.buildSessionFactory();
            sessionFactory = sessionFactorySampleDB;
        } catch (Exception e) {
            log.severe(e.getMessage());
            System.exit(0);
            return null;
        }
        return sessionFactory;
    }

    public static Session openConnection(String db) {
        if ("SampleDB".equals(db)) {
            sessionFactory = sessionFactorySampleDB;
        }
        if ("SkillDB".equals(db)) {
            sessionFactory = sessionFactorySkillDB;
        }
        if (session != null) {
            return session.isOpen() ? session : sessionFactory.openSession();
        } else {

        }
        return sessionFactory.openSession();
    }

    public static void closeConnection() {
        if (session != null && session.isOpen()) {
            session.close();
        }
        sessionFactory.close();
    }

    public static <T> List<T> createQuery(String query) {
        session = openConnection(database);
        return session.createQuery(query).list();
    }

    public static <T> void save(T... array) {
        if (session == null) {
            session = sessionFactory.openSession();
        }
        save(session, array);
    }

    public static <T> void save(Session session, T... array) {
        try {
            if (!session.isOpen()) {
                session = sessionFactory.openSession();
            }
            session.beginTransaction();
            for (int index = 0, n = array.length; index < n; index++) {
                session.save(array[index]);
            }
            session.getTransaction().commit();
            session.flush();
            log.info("SAVE Success");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.severe(e.getMessage());
            log.info("SAVE Failed");
        } finally {
            session.close();
        }
    }

    public static <T> void update(Session session, T obj) {
        try {
            if (!session.isOpen()) {
                session = sessionFactory.openSession();
            }
            session.beginTransaction();
            session.update(obj);
            session.getTransaction().commit();
            log.info("UPDATE Success");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.severe(e.getMessage());
        } finally {
            session.close();
        }
    }

    public static <T> void delete(Session session, T obj) {
        try {
            if (!session.isOpen()) {
                session = sessionFactory.openSession();
            }
            session.beginTransaction();
            session.delete(obj);
            session.getTransaction().commit();
            log.info("DELETE Success");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.severe(e.getMessage());
        } finally {
            session.close();
        }
    }

    public static SessionFactory getSessionFactory(String pdatabase) {
        database = pdatabase;
        return sessionFactory == null ? configure() : sessionFactory;
    }
}
