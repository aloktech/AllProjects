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
public class BIMEstimate {

    private String subscriptionPlanId;
    private String subscription;
    private String billingAddressLine1;
    private String billingAddressLine2;
    private String billingAddressCity;
    private String billingAddressZip;
    private String billingAddressCountry;
    private Integer billingCycle;
    private Integer subscriptionPlanQuantity;

    public static class BIMEstimateBuilder {

        public BIMEstimateBuilder() {
        }
    }
}
