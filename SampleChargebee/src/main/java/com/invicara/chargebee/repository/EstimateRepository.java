/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee.repository;

import com.chargebee.Result;
import com.chargebee.models.Customer;
import com.chargebee.models.Estimate;
import com.invicara.chargebee.common.AbstractRepository;
import com.invicara.chargebee.common.EstimateType;
import com.invicara.chargebee.common.Repository;
import com.invicara.chargebee.model.BIMEstimate;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

/**
 *
 * @author alok
 */
@Log
public class EstimateRepository extends AbstractRepository implements Repository<Estimate> {

    @Getter
    @Setter
    private BIMEstimate estimate;

    @Getter
    @Setter
    private EstimateType estimateType;

    public EstimateRepository() {
    }

    @Override
    public Optional<Estimate> create() {
        Result result;
        try {
            result = Estimate.createSubscription()
                    .subscriptionPlanId(setStringValue(estimate.getSubscriptionPlanId()))
                    .request();
            log.info(setMessage("Creation of Estimate is successful", null));
            return Optional.of(result.estimate());
        } catch (IOException ex) {
            log.severe(setMessage("Creation of Estimate failed due to %s", ex));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Estimate> getById(String id) {
        return Optional.empty();
    }

    @Override
    public boolean updateById(String id, String... value) {

        Result result = null;
        try {
            if (estimateType == null || estimateType == EstimateType.NONE) {
            } else if (estimateType == EstimateType.RENEW) {
                result = Estimate.renewalEstimate(id)
                        .request();

            } else if (estimateType == EstimateType.UPDATE) {
                result = Estimate.updateSubscription()
                        .subscriptionId(setStringValue(estimate.getSubscription()))
                        .request();
            }
            System.out.println(result == null ? "" : result.estimate());
        } catch (IOException ex) {
            Logger.getLogger(CustomerRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean deleteById(String id) {

        Result result;
        try {
            result = Customer.delete(id)
                    .request();
        } catch (IOException ex) {
            Logger.getLogger(CustomerRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
