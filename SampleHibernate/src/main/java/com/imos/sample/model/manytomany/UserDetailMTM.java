/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.model.manytomany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author INVCH018
 */
@Entity
@Table(name = "user_detail_mtm")
@Getter
@Setter
@EqualsAndHashCode(exclude = {"vehicles"})
@ToString
public class UserDetailMTM implements Serializable {

    private static final long serialVersionUID = -5724972191280118668L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String userName;
    
    @ManyToMany
    private Collection<VehicleMTM> vehicles = new ArrayList<>();
}