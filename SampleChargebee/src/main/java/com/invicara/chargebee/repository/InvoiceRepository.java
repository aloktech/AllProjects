/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee.repository;

import com.chargebee.Result;
import com.chargebee.models.Invoice;
import com.invicara.chargebee.common.AbstractRepository;
import com.invicara.chargebee.common.Repository;
import com.invicara.chargebee.model.BIMInvoice;
import java.util.Optional;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

/**
 *
 * @author alok
 */
@Log
public class InvoiceRepository extends AbstractRepository implements Repository<Invoice> {

    @Getter
    @Setter
    private BIMInvoice invoice;

    @Override
    public Optional<Invoice> create() {
        try {
            Result result = Invoice.charge()
                    .customerId(setStringValue(invoice.getCustomerId()))
                    .amount(setIntegerValue(invoice.getChargeAmount()))
                    .description(setStringValue(invoice.getChargeDescription()))
                    .request();
            log.info(setMessage("Creation of Invoice is successful", null));
            return Optional.of(result.invoice());
        } catch (Exception e) {
            log.severe(setMessage("Creation of Invoice failed due to %s", e));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Invoice> getById(String id) {
        try {
            Result result = Invoice.retrieve(id).request();
            return Optional.of(result.invoice());
        } catch (Exception e) {
            log.severe(setMessage("Get a Invoice failed due to %s", e));
        }
        return Optional.empty();
    }

    @Override
    public boolean updateById(String id, String... value) {
//        try {
//            Result result = Invoice.update(id)
//                    .invoiceName(value[0])
//                    .request();
//            Invoice plan = result.plan();
//            return plan != null;
//        } catch (Exception e) {
//            log.severe(setMessage("Update a Invoice failed due to %s", e));
//        }
        return true;
    }

    @Override
    public boolean deleteById(String id) {
////        try {
//            Result result = Invoice.delete(id)
//                    .request();
//            Invoice plan = result.plan();
//            return plan != null;
//        } catch (Exception e) {
//            log.severe(setMessage("Deleting a Invoice failed due to %s", e));
//        }
        return false;
    }

}
