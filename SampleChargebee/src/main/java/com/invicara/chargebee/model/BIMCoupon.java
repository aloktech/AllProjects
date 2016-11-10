/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee.model;

import com.chargebee.models.Coupon.ApplyOn;
import com.chargebee.models.Coupon.DiscountType;
import com.chargebee.models.Coupon.DurationType;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author alok
 */
@Data
@Builder
public class BIMCoupon {

    private String id;
    private String name;
    private String lastName;
    private Integer discountAmmount;
    private DiscountType discountType;
    private ApplyOn applyOn;
    private DurationType durationType;

    public static class BIMCouponBuilder {

        public BIMCouponBuilder() {}
    }
}
