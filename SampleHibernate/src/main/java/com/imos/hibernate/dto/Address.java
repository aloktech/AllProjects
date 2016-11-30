/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Alok
 */
@Embeddable
@Getter
@Setter
public class Address extends BaseObject {
    
    @Column(name = "FIRST_STREET")
    private String firstStreet;
    @Column(name = "SECOND_STREET")
    private String secondStreet;
    @Column(name = "FLAT")
    private String flat;
    @Column(name = "BUILDING")
    private String building;
    @Column(name = "PIN_CODE")
    private int pinCode;
    @Column(name = "CITY")
    private String city;
    @Column(name = "COUNTRY_STATE")
    private String countryState;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "ADDRESS_TYPE")
    private AddressType addressType;

    @Override
    public String toString() {
        return "SSS";
    }
    
    
}
