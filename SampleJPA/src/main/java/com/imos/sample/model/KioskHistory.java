/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Pintu
 */
@Getter
@Setter
@Entity
@Table(name = "kiosk_history")
public class KioskHistory extends BasicModel {

    private static final long serialVersionUID = 1225189964634955895L;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created")
    private Date created;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated")
    private Date updated;
    
    @Column(name = "action_type")
    private String actionType;

//    @ElementCollection
//    @ManyToOne(targetEntity = KioskDetail.class)
//    private Set<KioskDetail> kioskDetails;
}
