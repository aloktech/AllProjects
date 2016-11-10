/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee.test;

import com.chargebee.models.Invoice;
import com.invicara.chargebee.model.BIMInvoice;
import com.invicara.chargebee.repository.InvoiceRepository;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;

import static com.invicara.chargebee.test.AbstractTest.injector;

/**
 *
 * @author alok
 */
public class InvoiceTest extends AbstractTest<InvoiceRepository> {

    private final InvoiceRepository repository = injector.getInstance(InvoiceRepository.class);

    @Test
    public void test() {
        create();
//        getById();
//        update();
//        delete();
    }

    @Override
    public void create() {
        BIMInvoice invoice = new BIMInvoice.BIMInvoiceBuilder()
                .customerId("IG5ryp3PvMAfk8gpH")
                .chargeAmount(1000)
                .chargeDescription("Support charge")
                .build();

        repository.setInvoice(invoice);
        Optional<Invoice> optional = repository.create();
        optional.ifPresent(c -> {
            System.out.println(c);
        });
    }

    @Override
    public void getById() {
        Optional<Invoice> optional = repository.getById("premium_pack");
        optional.ifPresent(p -> {
            System.out.println(p);
//            Assert.assertEquals("Success", "free-trial", p);
        });
    }

    @Override
    public void update() {
        boolean status = repository.updateById("free-trial", "Free Trial Plan A");
        Assert.assertTrue(status);
        Optional<Invoice> optional = repository.getById("free-trial");
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
