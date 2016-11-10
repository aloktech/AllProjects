/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee.common;

import com.chargebee.Environment;
import java.sql.Timestamp;
import java.time.Instant;

/**
 *
 * @author alok
 */
public class AbstractRepository {

    public AbstractRepository() {
        Environment.configure("imos-test", "test_dpUemkTT0qmzCF8DCi6H6PZ7owM9stWO");
    }

    protected Integer setIntegerValue(Integer value) {
        return value == null ? 0 : value;
    }

    protected String setStringValue(String value) {
        return value == null ? "" : value;
    }

    protected Timestamp setTimestampValue(Timestamp value) {
        return value == null ? Timestamp.from(Instant.now()) : value;
    }

    protected String setMessage(String msg, Exception e) {
        return String.format(msg, e == null ? "" : e.getMessage());
    }
}
