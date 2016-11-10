/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author INVCH018
 */
@Table(name = "PERSON")
@Entity
@NamedQueries({
    @NamedQuery(name = "Person.getAll", query = "from Person p")
})
@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = {"id"})
public class Person implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "FIRST_NAME")
    private String firstName;
    
    @Column(name = "SECOND_NAME")
    private String secondName;
    
    @Column(name = "LAST_NAME")
    private String lastName;
    
    @Column(name = "GENDER")
    private Gender gender;
    
//    @ManyToMany(mappedBy = "persons", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private Set<Address> addresses = new HashSet<>();
    
    @ManyToOne
    private Address address;
}
