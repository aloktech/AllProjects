/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.database.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *
 * @author Pintu
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@Entity
@Table(name = "address")
public class Address extends BaseData {

    private static final long serialVersionUID = 7342747729057158343L;

    private String firstStreet;
    private String secondStreet;
    private String landMark;
    private String premiseDetail;
    private String location;
    private String city;
    private String stateName;
    private String country;
    private String pin;
}
