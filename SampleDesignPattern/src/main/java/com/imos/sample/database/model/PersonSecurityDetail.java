/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.database.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "person_security_detail")
public class PersonSecurityDetail extends BaseData {

    private static final long serialVersionUID = -2660227327530544976L;

    @Column(name = "email_id", nullable = false)
    private String email;
    private String userid;
    private String password;
    @Temporal(TemporalType.DATE)
    private Date passwordExpireDate;
    private String saltValue;
    private String mobileNumber;

}
