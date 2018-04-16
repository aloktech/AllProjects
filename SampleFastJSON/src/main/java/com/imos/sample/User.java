/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import com.alibaba.fastjson.annotation.JSONField;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author Pintu
 */
@Data
public class User {

    private Long   id;
    private String name;
    @JSONField(name = "date_of_birth")
    private Date dateOfBirth;
    private boolean married;
    private BigDecimal height;
}
