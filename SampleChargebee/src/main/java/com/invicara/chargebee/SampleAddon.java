/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee;

import com.chargebee.Environment;
import com.chargebee.Result;
import com.chargebee.models.Addon;
import com.chargebee.models.Addon.ChargeType;
import com.chargebee.models.Addon.PeriodUnit;
import com.chargebee.models.Addon.Type;
import java.io.IOException;

/**
 *
 * @author INVCH018
 */
public class SampleAddon {
    private SampleAddon(){}
    public static void main(String[] args) throws IOException {

        Environment.configure("imos-test", "test_dpUemkTT0qmzCF8DCi6H6PZ7owM9stWO");

        Result result = Addon.create()
                .id("sms_pack")
                .name("Sms Pack")
                .invoiceName("sample data pack")
                .chargeType(ChargeType.RECURRING)
                .price(200)
                .period(1)
                .periodUnit(PeriodUnit.MONTH)
                .type(Type.ON_OFF).request();
        Addon addon = result.addon();
        
        System.out.println(addon);
    }
}
