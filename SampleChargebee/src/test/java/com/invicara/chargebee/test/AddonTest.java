/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee.test;

import com.chargebee.models.Addon;
import com.invicara.chargebee.model.BIMAddon;
import com.invicara.chargebee.repository.AddonRepository;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;

import static com.invicara.chargebee.test.AbstractTest.injector;

/**
 *
 * @author alok
 */
public class AddonTest extends AbstractTest<AddonRepository> {

    private final AddonRepository repository = injector.getInstance(AddonRepository.class);

    @Test
    public void test() {
        create();
        getById();
//        update();
//        delete();
    }

    @Override
    public void create() {
        BIMAddon addon = new BIMAddon.BIMAddonBuilder()
                    .id("premium_pack")
                    .name("Premium Pack")
                    .invoiceName("BIM Premium Pack")
                    .chargeType(Addon.ChargeType.NON_RECURRING)
                    .price(200)
                    .period(1)
                    .periodUnit(Addon.PeriodUnit.MONTH)
                    .type(Addon.Type.ON_OFF)
                .build();

        repository.setAddon(addon);
        Optional<Addon> optional = repository.create();
        optional.ifPresent(c -> {
            System.out.println(c);
        });
    }

    @Override
    public void getById() {
        Optional<Addon> optional = repository.getById("premium_pack");
        optional.ifPresent(p -> {
            System.out.println(p);
//            Assert.assertEquals("Success", "free-trial", p);
        });
    }

    @Override
    public void update() {
        boolean status = repository.updateById("free-trial", "Free Trial Plan A");
        Assert.assertTrue(status);
        Optional<Addon> optional = repository.getById("free-trial");
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
