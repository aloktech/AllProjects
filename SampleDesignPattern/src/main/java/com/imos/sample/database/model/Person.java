/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.database.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *
 * @author Pintu
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Entity
@Table(name = "person")
public class Person extends BaseData {

    private static final long serialVersionUID = -2505675693262051587L;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pd_id")
    private PersonDetail personDetail;
}
