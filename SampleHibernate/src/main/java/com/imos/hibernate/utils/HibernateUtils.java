/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.hibernate.utils;

import java.util.List;
import java.util.logging.Level;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Alok
 */
@Log
public class HibernateUtils {

    private static HibernateUtils instance;

    @Setter
    @Getter
    private Database database;

    @Getter
    private SessionFactory sessionFactory;
    private  SessionFactory sampleDBsessionFactory;
    private  SessionFactory skillDBsessionFactory;
    @Getter
    private Session session;

    private HibernateUtils() {
        sampleDBsessionFactory = new Configuration().configure("hibernate_sampledb.cfg.xml").buildSessionFactory();
//        skillDBsessionFactory = new Configuration().configure("hibernate_skilldb.cfg.xml").buildSessionFactory();
//        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    public static HibernateUtils getInstance() {
        if (instance == null) {
            try {
                instance = new HibernateUtils();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return instance;
    }

    public Session openSession() {
        assignDatabase();
        if (session == null) {
            session = sessionFactory.openSession();
        }
        if (!session.isOpen()) {
            session = sessionFactory.openSession();
        }
        return session;
    }

    private void assignDatabase() {
        switch (database) {
            case SAMPLE_DB:
                sessionFactory = sampleDBsessionFactory;
                break;
            case SKILL_DB:
                sessionFactory = skillDBsessionFactory;
                break;
        }
    }

    public void closeSession() {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public void closeConnection() {
        sessionFactory.close();
        sampleDBsessionFactory.close();
//        skillDBsessionFactory.close();
//        sessionFactory.close();
    }

    public List executeQuery(String query) {
        session = openSession();
        List list = session.createQuery(query).list();
        closeSession();
        return list;
    }

    public <T> void save(T... objs) {
        session = openSession();

        try {
            session.beginTransaction();
            for (T obj : objs) {
                session.save(obj);
            }
            session.getTransaction().commit();
            log.info("SAVE Successfull");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.log(Level.INFO, "SAVE Failure {0}", e.getMessage());
            e.printStackTrace();
        } finally {
            closeSession();
        }
    }
}
