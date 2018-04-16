/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.database.test;

import com.imos.sample.database.repository.PersistenceRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Pintu
 */
@Disabled
public class ProductionDBTest {

    private static PersistenceRepository repo;

    @Disabled
    @BeforeAll
    public static void setUp() {
        System.out.println("");
        repo = new PersistenceRepository("SampleJPAUnit");
        repo.configure();
    }

    @Disabled
    @AfterAll
    public static void shutDown() {
        repo.shutDown();
    }

    @Disabled
    @Test
    public void testingDB() {
        try {
            repo.open();
        } catch (Exception e) {
        } finally {
            repo.close();
        }
    }
}
