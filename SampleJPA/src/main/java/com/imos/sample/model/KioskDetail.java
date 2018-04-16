/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Pintu
 */
@Getter
@Setter
@Entity
@Table(name = "kiosk_detail")
public class KioskDetail extends BasicModel {

    private static final long serialVersionUID = 2393011473061224253L;

    @Column(name = "kiosk_id")
    private String kioskId;
    
    @Column(name = "ip_address")
    private String ipAddress;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "connection_type")
    private ConnectionType connectionType;
    
//    @OneToMany(mappedBy = "kioskDetails")
//    private KioskHistory kioskHistory;
}
