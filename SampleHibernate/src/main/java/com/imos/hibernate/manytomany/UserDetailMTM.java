/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.hibernate.manytomany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Alok
 */
@Entity
@Table
@Getter
@Setter
//@ToString(exclude = {"id", "vehicles"})
@ToString(exclude = {"id"})
public class UserDetailMTM implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;

//    @ManyToMany(fetch = FetchType.LAZY)
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "owners", targetEntity = VehicleMTM.class)
//    @JoinTable(name = "USERS_VEHICLES", joinColumns = {@JoinColumn(name = "user_fk")}, inverseJoinColumns = {@JoinColumn(name = "vehicle_fk")})
    private Collection<VehicleMTM> vehicles = new ArrayList<>();
}
