/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.database.repository;

import com.imos.sample.database.EventType;
import com.imos.sample.database.IEntity;
import com.imos.sample.database.exception.RepositoryException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 *
 * @author Pintu
 * @param <I>
 * @param <O>
 */
@Log4j2
public class HibernateRepository<I extends IEntity, O extends IEntity> extends AbstractRepository {

    private SessionFactory sessionFactory;
    protected Session session;

    protected Function<I, Serializable> addEntity = (i) -> {
        Serializable id = session.save(i);
        return id;
    };

    protected Function<I, Void> updateEntity = (i) -> {
        session.update(i);
        return null;
    };

    protected Function<I, Void> deleteEntity = (i) -> {
        session.delete(i);
        return null;
    };

    protected Function<I, Optional<I>> getById = (i) -> {
        try {
            return Optional.of((I) session.get(i.getClass(), i.getId()));
        } catch (Exception e) {
        }
        return Optional.empty();
    };

    private void configure() {
        log.info("Hibernate Configuration");
    }

    private void open() {
        if (sessionFactory == null) {
            configure();
        }
        session = sessionFactory.openSession();
        log.info("Hibernate session is opened");
    }

    protected <I, O> O execute(Function<I, O> executor, I input, EventType eventType) throws RepositoryException {
        O result = null;
        try {
            open();
            session.getTransaction().begin();
            result = executor.apply(input);
            session.getTransaction().commit();
            log.info("Hibernate database event {} succeed", eventType.name());
        } catch (Exception e) {
            log.info("Hibernate database event {} failed", eventType.name());
            session.getTransaction().rollback();
            throw new RepositoryException(e);
        } finally {
            close();
        }
        return result;
    }

    protected void close() {
        if (sessionFactory == null) {
            log.info("Hibernate is not configured");
            throw new IllegalStateException("Invalid Database configuration");
        }
        if (session == null) {
            log.info("Hibernate session is not configured");
            throw new IllegalStateException("Database session is not opened");
        }
        if (session.isOpen()) {
            log.info("Hibernate session is already closed");
        } else {
            session.close();
            log.info("Hibernate session is closed");
        }
    }

    public void add(I input) throws RepositoryException {
        execute(addEntity, input, EventType.SAVE);
        log.info("Entity {} is saved to database", input.getClass().getSimpleName());
    }

    public void update(I input) throws RepositoryException {
        Optional<I> tempData = execute(getById, input, EventType.JPA_QUERY);
        if (tempData.isPresent()) {
            execute(updateEntity, input, EventType.UPDATE);
            log.info("Entity {} is updated to database", input.getClass().getSimpleName());
        } else {
            log.info("Entity {} is not available in database", input.getClass().getSimpleName());
        }
    }

    public void delete(I input) throws RepositoryException {
        Optional<I> tempData = execute(getById, input, EventType.JPA_QUERY);
        if (tempData.isPresent()) {
            execute(deleteEntity, input, EventType.DELETE);
            log.info("Entity {} is deleted from database", input.getClass().getSimpleName());
        } else {
            log.info("Entity {} is not available in database", input.getClass().getSimpleName());
        }
    }

    public List<O> executeQuery(String queryStr, Class<O> cls, boolean uniqueResult) throws RepositoryException {
        List<O> result = new ArrayList<>();
        try {
            open();
            session.getTransaction().begin();
            Query<O> query = session.createQuery(queryStr, cls);
            if (uniqueResult) {
                result.add(query.getSingleResult());
            } else {
                result = query.getResultList();
            }
            session.getTransaction().commit();
            log.info("Hibernate database event {} succeed", EventType.JPA_QUERY.name());
        } catch (Exception e) {
            log.info("Hibernate database event {} failed", EventType.JPA_QUERY.name());
            session.getTransaction().rollback();
            throw new RepositoryException(e);
        } finally {
            close();
        }
        return result;
    }

    public O getUniqueResult(String queryStr, Class<O> cls) throws RepositoryException {
        List<O> resultList = executeQuery(queryStr, cls, true);
        if (resultList.isEmpty() || resultList.size() > 1) {
            log.info("Database donot have unique result for entity {}", cls.getSimpleName());
        }
        O result = resultList.get(0);
        log.info("Database has an unique result for entity {}", cls.getSimpleName());
        return result;
    }

    public List<O> getResult(String queryStr, Class<O> cls) throws RepositoryException {
        List<O> resultList = executeQuery(queryStr, cls, false);
        log.info("Database has list of result for entity {}", cls.getSimpleName());
        return resultList;
    }
}
