/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee.repository;

import com.chargebee.Result;
import com.chargebee.models.Plan;
import com.invicara.chargebee.common.AbstractRepository;
import com.invicara.chargebee.common.Repository;
import com.invicara.chargebee.model.BIMPlan;
import java.util.Optional;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

/**
 *
 * @author alok
 */
@Log
public class PlanRepository extends AbstractRepository implements Repository<Plan> {

    @Getter
    @Setter
    private BIMPlan plan;

    @Override
    public Optional<Plan> create() {
        try {
            Result result = Plan.create()
                    .id(setStringValue(plan.getId()))
                    .name(setStringValue(plan.getName()))
                    .invoiceName(setStringValue(plan.getInvoiceName()))
                    .price(setIntegerValue(5000))
                    .request();
            log.info(setMessage("Creation of Plan is successful", null));
            return Optional.of(result.plan());
        } catch (Exception e) {
            log.severe(setMessage("Creation of Plan failed due to %s", e));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Plan> getById(String id) {
        try {
            Result result = Plan.retrieve(id).request();
            return Optional.of(result.plan());
        } catch (Exception e) {
            log.severe(setMessage("Get a Plan failed due to %s", e));
        }
        return Optional.empty();
    }

    @Override
    public boolean updateById(String id, String... value) {
        try {
            Result result = Plan.update(id)
                    .invoiceName(value[0])
                    .request();
            Plan plan = result.plan();
            return plan != null;
        } catch (Exception e) {
            log.severe(setMessage("Update a Plan failed due to %s", e));
        }
        return true;
    }

    @Override
    public boolean deleteById(String id) {
        try {
            Result result = Plan.delete(id)
                    .request();
            Plan plan = result.plan();
            return plan != null;
        } catch (Exception e) {
            log.severe(setMessage("Deleting a Plan failed due to %s", e));
        }
        return false;
    }

}
