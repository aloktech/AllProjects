/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee.test;

import com.chargebee.models.Subscription;
import com.invicara.chargebee.model.BIMSubscription;
import com.invicara.chargebee.repository.SubscriptionRepository;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author alok
 */
public class SubscriptionTest extends AbstractTest<SubscriptionRepository> {

    private final SubscriptionRepository repository = injector.getInstance(SubscriptionRepository.class);

    @Test
    public void test() {
//        create();
        getById();
//        update();
//        delete();
    }

    @Override
    public void create() {
        createSubscriptionFromCustomer();
    }

    public void createSubscriptionFromCustomer() {
        String subId = "1sjs9cNPvMGme3cGp";
        String id = "IG5ryp3PvMAfk8gpH";
        Calendar cal = GregorianCalendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 31);
        BIMSubscription subscription = new BIMSubscription.BIMSubscriptionBuilder()
                .customerId(id)
//                .startDate(new Timestamp(cal.getTimeInMillis()))
                .planId("free-trial")
                .build();
        repository.setSubscription(subscription);

        Optional<Subscription> op = repository.createForCustomerId();
        op.ifPresent((s) -> {
            System.out.println(s);
            System.out.println(s.id());
        });
    }

    @Override
    public void getById() {
        String id = "1sjs9cNPvMGme3cGp";
        Optional<Subscription> optional = repository.getById(id);
        optional.ifPresent(s -> {
            System.out.println(s);
            Assert.assertEquals(id, s.id());
        });

    }

    @Override
    public void update() {
        String id = "HtZEwQTPvGWc1O10m7";
        repository.updateById(id, "Pintu");
        Subscription subscription = repository.getById(id).get();
//        Assert.assertEquals("Pintu", subscription.firstName());
    }

    @Override
    public void delete() {
        String id = "HtZEwQTPvGWc1O10m7";
        repository.deleteById(id);
        Subscription subscription = repository.getById(id).get();
        Assert.assertEquals(id, subscription.id());
    }

}
