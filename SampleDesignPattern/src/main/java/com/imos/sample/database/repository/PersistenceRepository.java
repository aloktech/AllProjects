/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.database.repository;

import com.imos.sample.database.EventType;
import com.imos.sample.database.IEntity;
import com.imos.sample.database.exception.RepositoryException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import lombok.extern.log4j.Log4j2;

/**
 *
 * @author Pintu
 * @param <I>
 * @param <O>
 */
@Log4j2
public class PersistenceRepository<I extends IEntity, O extends IEntity> extends AbstractRepository {

    private EntityManagerFactory emFactory;
    private EntityManager entityManager;
    private final String persistenceUnit;

    public PersistenceRepository(String persistenceUnit) {
        this.persistenceUnit = persistenceUnit;
    }

    BiFunction<EntityManager, I, Void> addEntity = (em, in) -> {
        em.persist(in);
        return null;
    };

    BiFunction<EntityManager, I, I> updateEntity = (em, in) -> {
        I result = null;
        try {
            result = (I) em.merge(in);
        } catch (Exception e) {
        }
        return result;
    };

    BiFunction<EntityManager, I, Void> deleteEntity = (em, in) -> {
        em.remove(in);
        return null;
    };

    BiFunction<EntityManager, I, Optional<I>> getById = (em, in) -> {
        try {
            return Optional.of((I) em.find(in.getClass(), in.getId()));
        } catch (Exception e) {
        }
        return Optional.empty();
    };

    public void configure() {
        emFactory = Persistence.createEntityManagerFactory(persistenceUnit);
        log.info("JPA Configuration is successfull");
        log.info("JPA EnityManager Factory is opened");
    }

    public void open() {
        if (persistenceUnit == null || persistenceUnit.isEmpty()) {
            throw new IllegalStateException("Persistence Unit cannot be empty");
        }
        if (emFactory == null) {
            configure();
        }
        entityManager = emFactory.createEntityManager();
        log.info("JPA session is opened");
    }

    public void close() {
        if (emFactory == null) {
            log.info("JPA is not configured");
            throw new IllegalStateException("Invalid Database configuration");
        }
        if (entityManager == null) {
            log.info("JPA session is not configured");
            throw new IllegalStateException("Database session is not opened");
        }
        if (entityManager.isOpen()) {
            entityManager.close();
            log.info("JPA session is closed");
        } else {
            log.info("JPA session is already closed");
        }
    }

    public void shutDown() {
        if (emFactory != null && emFactory.isOpen()) {
            emFactory.close();
            log.info("JPA EnityManager Factory is closed");
        } else {
            log.info("JPA EnityManager Factory was not opened");
        }
    }

    public void add(I input) throws RepositoryException {
        execute(addEntity, input, EventType.SAVE);
        log.info("Entity '{}' is saved to database", input.getClass().getSimpleName());
    }

    public void update(I input) throws RepositoryException {
        input.setLastUpdateDate(new Date());
        Optional<I> tempData = execute(getById, input, EventType.JPA_QUERY);
        if (tempData.isPresent()) {
            log.info("Entity '{}' is available in database", input.getClass().getSimpleName());
            execute(updateEntity, input, EventType.UPDATE);
            log.info("Entity '{}' is updated to database", input.getClass().getSimpleName());
        } else {
            log.info("Entity '{}' is not available in database", input.getClass().getSimpleName());
        }
    }

    public void delete(I input) throws RepositoryException {
        input.setDeleteDate(new Date());
        Optional<I> tempData = execute(getById, input, EventType.JPA_QUERY);
        if (tempData.isPresent()) {
            log.info("Entity '{}' is available in database", input.getClass().getSimpleName());
            execute(deleteEntity, input, EventType.DELETE);
            log.info("Entity '{}' is deleted from database", input.getClass().getSimpleName());
        } else {
            log.info("Entity '{}' is not available in database", input.getClass().getSimpleName());
        }
    }

    public <I, O> O execute(BiFunction<EntityManager, I, O> executor, I input, EventType eventType) throws RepositoryException {
        O result = null;
        try {
            entityManager.getTransaction().begin();
            result = executor.apply(entityManager, input);
            entityManager.getTransaction().commit();
            log.info("Database event {} is called", eventType.name());
        } catch (Exception e) {
            causeOfException(e);
            log.info("Database event {} failed to called: {}", eventType.name());
            entityManager.getTransaction().rollback();
            throw new RepositoryException(e);
        }
        return result;
    }

    public void executeSQL(String sqlStr) throws RepositoryException {
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery(sqlStr);
            query.executeUpdate();
            entityManager.getTransaction().commit();
            log.info("Database event {} is called", EventType.SQL_QUERY.name());
        } catch (Exception e) {
            causeOfException(e);
            log.info("Database event {} failed to called: {}", EventType.SQL_QUERY.name());
            entityManager.getTransaction().rollback();
            throw new RepositoryException(e);
        }
    }

    public void executeNativeSQL(String sqlStr) throws RepositoryException {
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createNativeQuery(sqlStr);
            query.executeUpdate();
            entityManager.getTransaction().commit();
            log.info("Database event {} is called", EventType.SQL_NATIVE_QUERY.name());
        } catch (Exception e) {
            causeOfException(e);
            log.info("Database event {} failed to called: {}", EventType.SQL_NATIVE_QUERY.name());
            entityManager.getTransaction().rollback();
            throw new RepositoryException(e);
        }
    }

    public List<O> executeQueryForResult(String queryStr, Class<O> cls, boolean uniqueResult) throws RepositoryException {
        List<O> result = new ArrayList<>();
        try {
            entityManager.getTransaction().begin();
            TypedQuery<O> query = entityManager.createQuery(queryStr, cls);
            if (uniqueResult) {
                result.add(query.getSingleResult());
            } else {
                result = query.getResultList();
            }
            entityManager.getTransaction().commit();
            log.info("Database event {} is called", EventType.JPA_QUERY.name());
        } catch (Exception e) {
            causeOfException(e);
            log.info("Database event {} failed to called", EventType.JPA_QUERY.name());
            entityManager.getTransaction().rollback();
            throw new RepositoryException(e);
        }
        return result;
    }

    public void causeOfException(Exception e) {
        Throwable th = e.getCause();
        while (th != null) {
            log.info("Cause of error: {}", th.getMessage());
            th = th.getCause();
        }
    }

    public O getUniqueResult(String queryStr, Class<O> cls) throws RepositoryException {
        List<O> result = executeQueryForResult(queryStr, cls, true);
        return result.get(0);
    }

    public List<O> getResult(String queryStr, Class<O> cls) throws RepositoryException {
        return executeQueryForResult(queryStr, cls, false);
    }
}
