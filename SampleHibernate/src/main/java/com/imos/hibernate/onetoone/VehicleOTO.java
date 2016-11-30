/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.hibernate.onetoone;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Alok
 */
@Entity
@Table(schema = "sampledb.vehicleoto")
@Getter
@Setter
@ToString(exclude = {"id", "owner"})
public class VehicleOTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    
    private String name;
    
    @OneToOne(mappedBy = "vehicle")
    private UserDetailOTO owner;
}
