/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.database.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *
 * @author Pintu
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@Entity
@Table(name = "person_name")
public class PersonName extends BaseData {

    private static final long serialVersionUID = -8311419395981907807L;

    @Size(min = 6, max = 30, message = "First Name cannot be less than 6 characters or more than 30 characters")
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String lastName;
    private String nickName;
    @Transient
    private String fullName;

}
