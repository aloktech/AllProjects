/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author alok
 */
@Data
@Builder
public class BIMSubscription {

    private String customerId;
    private String planId;
    private String billingAddressFirstName;
    private String billingAddressLastName;
    private Timestamp startDate;
    private Integer price;
    private List<String> addons = new ArrayList<>();
    private List<String> coupons = new ArrayList<>();

    public static class BIMSubscriptionBuilder {

        public BIMSubscriptionBuilder() {}
    }
}
