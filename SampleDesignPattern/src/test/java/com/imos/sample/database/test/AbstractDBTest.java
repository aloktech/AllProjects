/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.database.test;

import com.imos.sample.database.exception.RepositoryException;
import com.imos.sample.database.repository.PersistenceRepository;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Pintu
 */
@Log4j2
public abstract class AbstractDBTest {

    protected static PersistenceRepository repo;

    @BeforeAll
    protected static void setUp() {
        System.out.println("");
        repo = new PersistenceRepository("SampleJPATestUnit");
        repo.configure();
    }

    @AfterAll
    protected static void shutDown() {
        repo.shutDown();
        System.out.println("");
    }

    @BeforeEach
    protected void nextTest() {
        System.out.println("");
        System.out.println("#########");
        repo.open();
    }

    @AfterEach
    protected void afterTest() {
        try {
//            repo.executeNativeSQL("Truncate Table address");
//            repo.executeNativeSQL("Truncate Table person_name");
//            repo.executeNativeSQL("Truncate Table person_security_detail");
//            repo.executeNativeSQL("Truncate Table person_detail");
            repo.executeNativeSQL("Truncate Table person");
        } catch (RepositoryException ex) {
            Logger.getLogger(AbstractDBTest.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            repo.close();
        }
    }
}
