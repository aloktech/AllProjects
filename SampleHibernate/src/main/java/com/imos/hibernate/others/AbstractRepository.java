/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.hibernate.others;

import com.imos.hibernate.utils.HibernateUtils;
import java.util.List;
import lombok.Getter;
import lombok.extern.java.Log;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Pintu
 */
@Log
public abstract class AbstractRepository {

    private static HibernateUtils instance;
    @Getter
    private final SessionFactory sessionFactory;
    @Getter
    private Session session;

    public AbstractRepository() {
        instance = HibernateUtils.getInstance();
        sessionFactory = instance.getSessionFactory();
        session = sessionFactory.openSession();
    }

    public Session openSession() {
        if (!session.isOpen()) {
            session = sessionFactory.openSession();
        }
        return sessionFactory.getCurrentSession();
    }

    public void closeSession() {
        if (session.isOpen()) {
            session.close();
        }
    }

    public void closeConnection() {
        sessionFactory.close();
    }

    public List executeQuery(String query) {
        return session.createQuery(query).list();
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
            log.info("SAVE Failure");
        } finally {
            closeSession();
        }
    }

}
