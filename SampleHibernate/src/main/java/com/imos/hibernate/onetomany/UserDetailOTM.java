/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.hibernate.onetomany;

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
import javax.persistence.OneToMany;
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
//@ToString(exclude = {"id", "vehicle"})
@ToString(exclude = {"id"})
public class UserDetailOTM implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USER_VEHICLES", joinColumns = {@JoinColumn(name = "user_fk")}, inverseJoinColumns = {@JoinColumn(name = "vehicle_fk")})
    private Collection<VehicleOTM> vehicles = new ArrayList<>();
}
