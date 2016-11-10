/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee.test;

import com.chargebee.models.Coupon;
import com.invicara.chargebee.model.BIMCoupon;
import com.invicara.chargebee.repository.CouponRepository;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;

import static com.invicara.chargebee.test.AbstractTest.injector;

/**
 *
 * @author alok
 */
public class CouponTest extends AbstractTest<CouponRepository> {

    private final CouponRepository repository = injector.getInstance(CouponRepository.class);

    @Test
    public void test() {
//        create();
        getById();
//        update();
//        delete();
    }

    @Override
    public void create() {
        BIMCoupon card = new BIMCoupon.BIMCouponBuilder()
                .id("bim_sample_offer")
                .name("BIM Sample Offer")
                .discountAmmount(500)
                .build();

        repository.setCoupon(card);
        Optional<Coupon> optional = repository.create();
        optional.ifPresent(c -> {
            System.out.println(c);
//            Assert.assertEquals("Success", "Alok", c.firstName());
        });
    }

    @Override
    public void getById() {
        Optional<Coupon> optional = repository.getById("bim_sample_offer");
        optional.ifPresent(p -> {
            System.out.println(p);
//            Assert.assertEquals("Success", "free-trial", p);
        });
    }

    @Override
    public void update() {
        boolean status = repository.updateById("free-trial", "Free Trial Plan A");
        Assert.assertTrue(status);
        Optional<Coupon> optional = repository.getById("free-trial");
        optional.ifPresent(p -> {
            Assert.assertEquals("Success", "Free Trial Plan A", p);
        });
    }

    @Override
    public void delete() {
        boolean status = repository.deleteById("free-trial");
        Assert.assertTrue(status);
        status = repository.deleteById("free-trial");
        Assert.assertFalse(status);
    }

}
