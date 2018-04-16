/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Pintu
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "suser")
public class SampleUser implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    private long id;
    
    private String fullName;
}
