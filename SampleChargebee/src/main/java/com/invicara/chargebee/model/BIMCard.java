/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee.model;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author alok
 */
@Data
@Builder
public class BIMCard {

    private String customerId;
    private String firstName;
    private String lastName;
    private String iin;
    private String last4;
    private String number;
    private String cvv;
    private String billingAddr1;
    private String billingAddr2;
    private String billingCity;
    private Integer expireMonth;
    private Integer expireYear;

    public static class BIMCardBuilder {

        public BIMCardBuilder() {}
    }
}
