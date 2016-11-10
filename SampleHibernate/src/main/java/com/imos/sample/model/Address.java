/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author INVCH018
 */
@Entity
@Table
@Getter
@Setter
@ToString(exclude = "id")
public class Address implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstStreet;
    private String secondStreet;
    private String city;
    private String state;
    private String country;
    private int pin;

//    @ManyToMany
//    private Set<Person> persons = new HashSet<>();
    @OneToMany
    private Set<Person> persons = new HashSet<>();
}
