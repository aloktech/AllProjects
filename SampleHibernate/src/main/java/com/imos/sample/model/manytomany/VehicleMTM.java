/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.model.manytomany;

import com.imos.sample.model.*;
import com.imos.sample.model.manytomany.UserDetailMTM;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@ToString(exclude = "owners")
public class VehicleMTM implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String vehicleName;
    @ManyToMany(mappedBy = "vehicles")
    private Collection<UserDetailMTM> owners = new ArrayList<>();
}
