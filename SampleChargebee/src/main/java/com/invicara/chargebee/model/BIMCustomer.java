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
public class BIMCustomer {

    private String firstName;
    private String lastName;
    private String email;
    private String billingAddressCompany;
    private String billingAddressFirstName;
    private String billingAddressLastName;
    private String billingAddressLine1;
    private String billingAddressLine2;
    private String billingAddressCity;
    private String billingAddressState;
    private String billingAddressStateCode;
    private String billingAddressCountry;
    private String company;
    private String phone;
    private Boolean allowDirectDebit;
    private Integer price;

    public static class BIMCustomerBuilder {

        public BIMCustomerBuilder() {}
    }
}
