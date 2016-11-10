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
public class BIMPlan {

    private String id;
    private String name;
    private String invoiceName;
    private Integer price;

    public static class BIMPlanBuilder {

        public BIMPlanBuilder() {}
    }
}
