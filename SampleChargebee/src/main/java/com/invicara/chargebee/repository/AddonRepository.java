/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee.repository;

import com.chargebee.Result;
import com.chargebee.models.Addon;
import com.invicara.chargebee.common.AbstractRepository;
import com.invicara.chargebee.common.Repository;
import com.invicara.chargebee.model.BIMAddon;
import java.util.Optional;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

/**
 *
 * @author alok
 */
@Log
public class AddonRepository extends AbstractRepository implements Repository<Addon> {

    @Getter
    @Setter
    private BIMAddon addon;

    @Override
    public Optional<Addon> create() {
        try {
            Result result = Addon.create()
                    .id(setStringValue(addon.getId()))
                    .name(setStringValue(addon.getName()))
                    .invoiceName(setStringValue(addon.getInvoiceName()))
                    .chargeType(Addon.ChargeType.RECURRING)
                    .price(setIntegerValue(addon.getPrice()))
                    .period(setIntegerValue(addon.getPeriod()))
                    .periodUnit(Addon.PeriodUnit.MONTH)
                    .type(Addon.Type.ON_OFF)
                    .request();
            log.info(setMessage("Creation of Addon is successful", null));
            return Optional.of(result.addon());
        } catch (Exception e) {
            log.severe(setMessage("Creation of Addon failed due to %s", e));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Addon> getById(String id) {
        try {
            Result result = Addon.retrieve(id).request();
            return Optional.of(result.addon());
        } catch (Exception e) {
            log.severe(setMessage("Get a Addon failed due to %s", e));
        }
        return Optional.empty();
    }

    @Override
    public boolean updateById(String id, String... value) {
//        try {
//            Result result = Addon.update(id)
//                    .invoiceName(value[0])
//                    .request();
//            Addon plan = result.plan();
//            return plan != null;
//        } catch (Exception e) {
//            log.severe(setMessage("Update a Addon failed due to %s", e));
//        }
        return true;
    }

    @Override
    public boolean deleteById(String id) {
////        try {
//            Result result = Addon.delete(id)
//                    .request();
//            Addon plan = result.plan();
//            return plan != null;
//        } catch (Exception e) {
//            log.severe(setMessage("Deleting a Addon failed due to %s", e));
//        }
        return false;
    }

}
