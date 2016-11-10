/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee.repository;

import com.chargebee.Result;
import com.chargebee.models.Coupon;
import com.invicara.chargebee.common.AbstractRepository;
import com.invicara.chargebee.common.Repository;
import com.invicara.chargebee.model.BIMCoupon;
import java.util.Optional;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

/**
 *
 * @author alok
 */
@Log
public class CouponRepository extends AbstractRepository implements Repository<Coupon> {

    @Getter
    @Setter
    private BIMCoupon coupon;

    @Override
    public Optional<Coupon> create() {
        try {
            Result result = Coupon.create()
                    .id(setStringValue(coupon.getId()))
                    .name(setStringValue(coupon.getName()))
                    .discountType(Coupon.DiscountType.FIXED_AMOUNT)
                    .discountAmount(500)
                    .applyOn(Coupon.ApplyOn.INVOICE_AMOUNT)
                    .durationType(Coupon.DurationType.FOREVER)
                    .request();
            log.info(setMessage("Creation of Coupon is successful", null));
            return Optional.of(result.coupon());
        } catch (Exception e) {
            log.severe(setMessage("Creation of Coupon failed due to %s", e));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Coupon> getById(String id) {
        try {
            Result result = Coupon.retrieve(id).request();
            return Optional.of(result.coupon());
        } catch (Exception e) {
            log.severe(setMessage("Get a Coupon failed due to %s", e));
        }
        return Optional.empty();
    }

    @Override
    public boolean updateById(String id, String... value) {
//        try {
//            Result result = Coupon.update(id)
//                    .invoiceName(value[0])
//                    .request();
//            Coupon plan = result.plan();
//            return plan != null;
//        } catch (Exception e) {
//            log.severe(setMessage("Update a Coupon failed due to %s", e));
//        }
        return true;
    }

    @Override
    public boolean deleteById(String id) {
////        try {
//            Result result = Coupon.delete(id)
//                    .request();
//            Coupon plan = result.plan();
//            return plan != null;
//        } catch (Exception e) {
//            log.severe(setMessage("Deleting a Coupon failed due to %s", e));
//        }
        return false;
    }

}
