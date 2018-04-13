/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import com.owlike.genson.annotation.JsonDateFormat;
import com.owlike.genson.annotation.JsonProperty;
import java.util.Date;

/**
 *
 * @author ameher
 */
public class Person {

    public String name;

    public int age;
    
    @JsonProperty(value = "dob")
    @JsonDateFormat(value = "yyyy-MM-dd")
    public Date dateOfBirth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", age=" + age + ", dateOfBirth=" + dateOfBirth + '}';
    }
}
