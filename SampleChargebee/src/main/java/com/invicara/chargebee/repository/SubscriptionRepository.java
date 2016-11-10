/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee.repository;

import com.chargebee.Result;
import com.chargebee.models.Subscription;
import com.chargebee.models.Subscription.CreateRequest;
import com.invicara.chargebee.common.AbstractRepository;
import com.invicara.chargebee.common.Repository;
import com.invicara.chargebee.model.BIMSubscription;
import java.util.List;
import java.util.Optional;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

/**
 *
 * @author alok
 */
@Log
public class SubscriptionRepository extends AbstractRepository implements Repository<Subscription> {

    @Getter
    @Setter
    private BIMSubscription subscription;

    @Override
    public Optional<Subscription> create() {
        try {
            CreateRequest createRequest = Subscription.create();
            createRequest = createRequest
                    .billingAddressFirstName(setStringValue(subscription.getBillingAddressFirstName()))
                    .billingAddressLastName(setStringValue(subscription.getBillingAddressLastName()));
            createRequest = addAddons(createRequest, subscription.getAddons());
            createRequest = addCoupons(createRequest, subscription.getCoupons());

            Result result = createRequest.request();
            log.info(setMessage("Creation of Subscription is successful", null));
            return Optional.of(result.subscription());
        } catch (Exception e) {
            log.severe(setMessage("Creation of Subscription failed due to %s", e));
        }
        return Optional.empty();
    }

    public CreateRequest addAddons(CreateRequest createRequest, List<String> addons) {
        int index = 0;
        for (String addon : addons) {
            createRequest.addonId(index, addon);
            index++;
        }
        return createRequest;
    }

    public CreateRequest addCoupons(CreateRequest createRequest, List<String> coupons) {
        coupons.stream().forEach((coupon) -> {
            createRequest.coupon(coupon);
        });
        return createRequest;
    }

    public Optional<Subscription> createForCustomerId() {
        try {
            Subscription.CreateForCustomerRequest customerRequest = Subscription.createForCustomer(setStringValue(subscription.getCustomerId()));
            int index = 0;
            for (String addon : subscription.getAddons()) {
                customerRequest.addonId(index, addon);
                index++;
            }
            subscription.getCoupons().stream().forEach((coupon) -> {
                customerRequest.coupon(coupon);
            });
            customerRequest.planId(subscription.getPlanId());
            
            Result result = customerRequest.request();
            log.info(setMessage("Creation of Subscription is successful", null));
            return Optional.of(result.subscription());
        } catch (Exception e) {
            log.severe(setMessage("Creation of Subscription failed due to %s", e));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Subscription> getById(String id) {
        try {
            Result result = Subscription.retrieve(id)
                    .request();
            return Optional.of(result.subscription());
        } catch (Exception e) {
        }
        return Optional.empty();
    }

    @Override
    public boolean updateById(String id, String... value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteById(String id) {
        try {
            Subscription.delete(id).request();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

}
