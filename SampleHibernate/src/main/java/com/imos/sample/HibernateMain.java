/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import com.imos.sample.model.Person;
import com.imos.sample.model.PersonDAO;
import java.util.List;
import lombok.extern.java.Log;
import org.hibernate.Session;

/**
 *
 * @author INVCH018
 */
@Log
public class HibernateMain {

    public static void main(String[] args) {


//        try {
//            Person person = new Person();
//            person.setFirstName("Alok");
//            person.setSecondName("Ranjan");
//            person.setLastName("Meher");
//            person.setGender(Gender.MALE);
//
//            Address chennaiAddress = new Address();
//            chennaiAddress.setCity("Chennai");
//            chennaiAddress.getPersons().add(person);
//
//            Address balangirAddress = new Address();
//            balangirAddress.setCity("Balangir");
//            balangirAddress.getPersons().add(person);
//
////            person.getAddresses().add(chennaiAddress);
////            person.getAddresses().add(balangirAddress);
//            person.setConrrespondenceAddress(chennaiAddress);
//            person.setOfficeAddress(chennaiAddress);
//
//            HibernateUtil.save(person);
//            
//            HibernateUtil.save(chennaiAddress);
//            HibernateUtil.save(balangirAddress);
////            HibernateUtil.save(person);
//        } catch (Exception e) {
//            log.severe(e.getMessage());
//        } finally {
//            sessionFactory.close();
//        }
    }

    private static void testPerson(final Session session) {
        //            Person person = new Person();
//            person.setFirstName("Alok");
//            person.setSecondName("Ranjan");
//            person.setLastName("Meher");
//            person.setGender(Gender.MALE);
//
//            HibernateUtil.save(session, person);
//
//            person = new Person();
//            person.setFirstName("Gayatri");
//            person.setLastName("Meher");
//            person.setGender(Gender.FEMALE);
//
//        HibernateUtil.save(session, person);
//            if (!session.isOpen()) {
//                session = sessionFactory.getCurrentSession();
//            }
        List<Person> list = new PersonDAO()
                .setNamedQuery(session, "Person.getAll")
                .executeQuery();
        list.stream().forEach(System.out::println);
//            List list = session.createQuery("SELECT firstName, secondName, lastName FROM Person").list();
//            System.out.println(list.size());
//            list.stream().forEach(o -> {
//                Person p = (Person) o;
//                System.out.println(p);
//            });
//            List list = session.createQuery("from Person as p").list();
//            System.out.println(list.size());
//            list.stream().forEach(p -> {
//                System.out.println(p);
//            });
//            List list  = session.createSQLQuery("SELECT firstName,p.lastName FROM PERSON").addEntity(Person.class).list();
//            System.out.println(list.size());
//            list.stream().forEach(p -> {
//                System.out.println(p.toString());
//            });
    }
}
