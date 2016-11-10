/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee.test;

import com.chargebee.models.Estimate;
import com.invicara.chargebee.common.EstimateType;
import com.invicara.chargebee.model.BIMEstimate;
import com.invicara.chargebee.repository.EstimateRepository;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;

import static com.invicara.chargebee.test.AbstractTest.injector;

/**
 *
 * @author alok
 */
public class EstimateTest extends AbstractTest<EstimateRepository> {

    private final EstimateRepository repository = injector.getInstance(EstimateRepository.class);

    @Test
    public void test() {
//        create();
//        getById();
        update();
//        delete();
    }

    @Override
    public void create() {
//        createSubscriptionPlan();
        createSubscription();
    }

    private void createSubscriptionPlan() {
        BIMEstimate estimate = new BIMEstimate.BIMEstimateBuilder()
                .subscriptionPlanId("free-trial")
                .build();

        repository.setEstimate(estimate);
        Optional<Estimate> optional = repository.create();
        optional.ifPresent(e -> {
            System.out.println(e);
        });
    }

    private void createSubscription() {
        BIMEstimate estimate = new BIMEstimate.BIMEstimateBuilder()
                .subscription("1sjs9cNPvMGme3cGp")
                .subscriptionPlanId("free-trial")
                .build();

        repository.setEstimate(estimate);
        Optional<Estimate> optional = repository.create();
        optional.ifPresent(e -> {
            System.out.println(e);
        });
    }

    @Override
    public void getById() {
        Optional<Estimate> optional = repository.getById("free-trial");
        optional.ifPresent(e -> {
        });
    }

    @Override
    public void update() {
//        renewEstimate();
        updateEstimate();
    }

    private void renewEstimate() {
        repository.setEstimateType(EstimateType.RENEW);
        repository.updateById("1sjs9cNPvMGme3cGp");
        
    }
    
    private void updateEstimate() {
        repository.setEstimateType(EstimateType.UPDATE);
        BIMEstimate estimate = new BIMEstimate.BIMEstimateBuilder()
                .subscriptionPlanId("free-trial")
                .subscription("1sjs9cNPvMGme3cGp")
                .build();

        repository.setEstimate(estimate);
        repository.updateById("1sjs9cNPvMGme3cGp");
    }

    @Override
    public void delete() {
        boolean status = repository.deleteById("free-trial");
        Assert.assertTrue(status);
        status = repository.deleteById("free-trial");
        Assert.assertFalse(status);
    }

}
