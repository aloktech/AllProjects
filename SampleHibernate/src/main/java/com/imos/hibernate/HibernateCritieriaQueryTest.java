/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.hibernate;

import com.imos.hibernate.dto.PersonDetails;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Alok
 */
public class HibernateCritieriaQueryTest {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();
                
                System.out.println("\nSelect All\n");
                Criteria criteria = session.createCriteria(PersonDetails.class);
                List<PersonDetails> list = criteria.list();
                list.stream().forEach((pd) -> {
                    System.out.println(pd);
                });

                System.out.println("\nSelect selected\n");
                criteria = session.createCriteria(PersonDetails.class);
                criteria.add(Restrictions.eq("userName", "Alok1"));
                list = criteria.list();
                list.stream().forEach((pd) -> {
                    System.out.println(pd);
                });

            } catch (Exception e) {
                System.out.println(e.getCause().toString() + " : " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getCause().toString() + " : " + e.getMessage());
        }
    }
}
