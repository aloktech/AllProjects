/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.hibernate.dto;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Alok
 */
@Entity
@NamedQuery(name = "Vehicle.getByVehicleType",
        query = "from Vehicle v where v.vehicleType = :vehicleType")
@Setter
@Getter
public class Vehicle extends BaseObject {

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @Column(name = "VEHICLE_ID")
//    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
//    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "USER_ID")
    private PersonDetails owner;

    @Column(name = "NAME")
    private String name;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "REG_NUM")
    private String registrationNumber;

    @Column(name = "INSURANCE_NUM")
    private BigDecimal insuranceValue;

    @Column(name = "PREMIUM_VALUE")
    private BigDecimal premiumValue;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_OF_PURCHASHED")
    private Date dateOfPurchased;

    @Column(name = "VEHICLE_TYPE")
    private VehicleType vehicleType;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        builder.append("name:");
        builder.append(name);
        builder.append(",");
        builder.append("model:");
        builder.append(model);
        builder.append(",");
        builder.append("vehicleType:");
        builder.append(vehicleType);
        builder.append(",");
        builder.append("dateOfPurchased:");
        builder.append(dateOfPurchased);
        builder.append(",");
        builder.append("premiumValue:");
        builder.append(premiumValue);
        builder.append(",");
        builder.append("registrationNumber:");
        builder.append(registrationNumber);
        builder.append("]");
        return builder.toString();
    }
}
