/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.model;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author INVCH018
 */
public class PersonDAO {

    private Query query;

    public List<Person> executeQuery() {
        return query.list();
    }

    public PersonDAO setNamedQuery(Session session, String namedPersonDAO) {
        query = session.getNamedQuery(namedPersonDAO);
        return this;
    }
}
