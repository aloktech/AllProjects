/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee.test;

import com.chargebee.models.Plan;
import com.invicara.chargebee.model.BIMPlan;
import com.invicara.chargebee.repository.PlanRepository;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;

import static com.invicara.chargebee.test.AbstractTest.injector;

/**
 *
 * @author alok
 */
public class PlanTest extends AbstractTest<PlanRepository> {

    private final PlanRepository repository = injector.getInstance(PlanRepository.class);

    @Test
    public void test() {
//        create();
        getById();
//        update();
//        delete();
    }

    @Override
    public void create() {
        BIMPlan plan = new BIMPlan.BIMPlanBuilder()
                .id("free-trial")
                .name("Free Trial")
                .invoiceName("Free Trial Plan")
                .price(5000)
                .build();

        repository.setPlan(plan);
        Optional<Plan> optional = repository.create();
        optional.ifPresent(p -> {
            Assert.assertEquals("Success", "free-trial", p.id());
        });
    }

    @Override
    public void getById() {
        Optional<Plan> optional = repository.getById("free-trial");
        optional.ifPresent(p -> {
            Assert.assertEquals("Success", "free-trial", p.id());
        });
    }

    @Override
    public void update() {
        boolean status = repository.updateById("free-trial", "Free Trial Plan A");
        Assert.assertTrue(status);
        Optional<Plan> optional = repository.getById("free-trial");
        optional.ifPresent(p -> {
            Assert.assertEquals("Success", "Free Trial Plan A", p.invoiceName());
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
