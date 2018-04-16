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
import static com.imos.sample.database.test.DBTest.repo;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Pintu
 */
@Log4j2
public class DBEntityTest extends AbstractDBTest {

    @DisplayName("Testing one")
    @Test
    public void emptyEntity() throws RepositoryException {
        Person person = new Person();
        repo.delete(person);
    }

    @DisplayName("Testing one")
    @Test
    public void addEntity() throws RepositoryException {
        Person person = new Person();
        PersonDetail pd = new PersonDetail();
        PersonName name = new PersonName();
        name.setFirstName("Alok");
        pd.setPersonName(name);
        person.setPersonDetail(pd);
        repo.add(person);
        List<Person> persons = repo.getResult("from Person p", Person.class);
        Assertions.assertEquals(1, persons.size());
        Assertions.assertEquals("Alok", person.getPersonDetail().getPersonName().getFirstName());
        System.out.println(persons.get(0));
    }

    @Test
    public void updateEntity() throws RepositoryException {
        Person person = new Person();
        PersonDetail pd = new PersonDetail();
        PersonName name = new PersonName();
        name.setFirstName("Alok");
        pd.setPersonName(name);
        person.setPersonDetail(pd);
        repo.add(person);
        List<Person> persons = repo.getResult("from Person p", Person.class);
        Assertions.assertEquals(1, persons.size());
        person = persons.get(0);
        System.out.println(persons.get(0));
        pd = person.getPersonDetail();
        name = new PersonName();
        name.setFirstName("Pintu");
        pd.setPersonName(name);
        person.setPersonDetail(pd);
        repo.update(person);
        persons = repo.getResult("from Person p", Person.class);
        Assertions.assertEquals(1, persons.size());
        person = persons.get(0);
        System.out.println(persons.get(0));
        Assertions.assertEquals("Pintu", person.getPersonDetail().getPersonName().getFirstName());
    }

    @Test
    public void invalidUpdateEntity() throws RepositoryException {
        Person person = new Person();
        PersonDetail pd = new PersonDetail();
        PersonName name = new PersonName();
        name.setFirstName("Alok");
        name = new PersonName();
        name.setFirstName("Pintu");
        pd.setPersonName(name);
        person.setPersonDetail(pd);
        repo.update(person);
    }

    @Test
    public void deleteEntity() throws RepositoryException {
        List<Person> persons = repo.getResult("from Person p", Person.class);
        Assertions.assertEquals(0, persons.size());
        Person person = new Person();
        PersonDetail pd = new PersonDetail();
        PersonName name = new PersonName();
        name.setFirstName("Alok");
        pd.setPersonName(name);
        person.setPersonDetail(pd);
        System.out.println(person);
        repo.add(person);
        persons = repo.getResult("from Person p", Person.class);
        Assertions.assertEquals(1, persons.size());
        person = persons.get(0);
        System.out.println(persons.get(0));
        repo.delete(person);
        persons = repo.getResult("from Person p", Person.class);
        Assertions.assertEquals(0, persons.size());
    }

    @Test
    public void uniqueEntity() throws RepositoryException {
        List<Person> persons = repo.getResult("from Person p", Person.class);
        Assertions.assertEquals(0, persons.size());
        Person person = new Person();
        PersonDetail pd = new PersonDetail();
        PersonName name = new PersonName();
        name.setFirstName("Alok");
        pd.setPersonName(name);
        person.setPersonDetail(pd);
        System.out.println(person);
        repo.add(person);
        person = (Person) repo.getUniqueResult("from Person p", Person.class);
        Assertions.assertEquals("Alok", person.getPersonDetail().getPersonName().getFirstName());
    }

    @Test
    public void notUniqueEntity() throws RepositoryException {
       List<Person> persons = repo.getResult("from Person p", Person.class);
        Assertions.assertEquals(0, persons.size());
        Person person = new Person();
        PersonDetail pd = new PersonDetail();
        PersonName name = new PersonName();
        name.setFirstName("Alok");
        pd.setPersonName(name);
        person.setPersonDetail(pd);
        System.out.println(person);
        repo.add(person);
        person = new Person();
        pd = new PersonDetail();
        name = new PersonName();
        name.setFirstName("Alok");
        pd.setPersonName(name);
        person.setPersonDetail(pd);
        System.out.println(person);
        repo.add(person);
        Assertions.assertThrows(RepositoryException.class, () -> {
            Person p = (Person) repo.getUniqueResult("from Person p", Person.class);
        });
    }
}
