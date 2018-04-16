/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.database.test;

import com.imos.sample.database.exception.RepositoryException;
import com.imos.sample.database.model.Person;
import com.imos.sample.database.model.PersonDetail;
import com.imos.sample.database.model.PersonName;
import com.imos.sample.database.repository.PersistenceRepository;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Pintu
 */
@Log4j2
public class DBTest {

    protected static PersistenceRepository repo;

    @Test
    public void emptyOpenTest() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            repo = new PersistenceRepository("");
            repo.open();
        });
    }

    @Test
    public void openTest() {
        repo = new PersistenceRepository("SampleJPATestUnit");
        repo.open();
    }

    @Test
    public void shutDownTest() {
        repo = new PersistenceRepository("SampleJPATestUnit");
        repo.configure();
        repo.open();
        repo.shutDown();
        repo.shutDown();
    }

    @Test
    public void closeTest() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            repo = new PersistenceRepository("");
            repo.close();
        });
    }

    @Test
    public void enitityManagerNotOpenedTest() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            repo = new PersistenceRepository("SampleJPATestUnit");
            repo.configure();
            repo.close();
        });
    }

    @Test
    public void closeAgainTest() {
        repo = new PersistenceRepository("SampleJPATestUnit");
        repo.configure();
        repo.open();
        repo.close();
        repo.close();
    }

}
