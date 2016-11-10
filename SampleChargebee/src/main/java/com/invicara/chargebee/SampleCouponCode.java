/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee;

import com.chargebee.Environment;
import com.chargebee.Result;
import com.chargebee.models.CouponCode;
import java.io.IOException;

/**
 *
 * @author INVCH018
 */
public class SampleCouponCode {

    public static void main(String[] args) throws IOException {

        Environment.configure("imos-test", "test_dpUemkTT0qmzCF8DCi6H6PZ7owM9stWO");

        Result result = CouponCode.create()
                .couponId("sample_offer")
                .couponSetName("Launch Promotion")
                .code("CBCC435").request();
        CouponCode couponCode = result.couponCode();

        System.out.println(couponCode);
    }
}
