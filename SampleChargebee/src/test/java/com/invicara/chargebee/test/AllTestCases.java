/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author alok
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    CustomerTest.class,
    PlanTest.class,
    CardTest.class,
    CouponTest.class,
    AddonTest.class,
    SubscriptionTest.class,
    EstimateTest.class
})
public class AllTestCases {

}
