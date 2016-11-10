/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee;

import com.chargebee.Environment;
import com.chargebee.Result;
import com.chargebee.models.Coupon;
import com.chargebee.models.Coupon.ApplyOn;
import com.chargebee.models.Coupon.DiscountType;
import com.chargebee.models.Coupon.DurationType;
import java.io.IOException;

/**
 *
 * @author INVCH018
 */
public class SampleCoupon {

    public static void main(String[] args) throws IOException {

        Environment.configure("imos-test", "test_dpUemkTT0qmzCF8DCi6H6PZ7owM9stWO");

        Result result = Coupon.create()
                .id("sample_offer")
                .name("Sample Offer")
                .discountType(DiscountType.FIXED_AMOUNT)
                .discountAmount(500)
                .applyOn(ApplyOn.INVOICE_AMOUNT)
                .durationType(DurationType.FOREVER).request();
        Coupon coupon = result.coupon();

        System.out.println(coupon);
    }
}
