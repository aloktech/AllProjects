/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee.test;

import com.chargebee.models.Customer;
import com.invicara.chargebee.model.BIMCustomer;
import com.invicara.chargebee.repository.CustomerRepository;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;

import static com.invicara.chargebee.test.AbstractTest.injector;

/**
 *
 * @author alok
 */
public class CustomerTest extends AbstractTest<CustomerRepository> {

    private final CustomerRepository repository = injector.getInstance(CustomerRepository.class);

    @Test
    public void test() {
//        create();
        getById();
//        update();
//        delete();
    }

    @Override
    public void create() {
        BIMCustomer customer = new BIMCustomer.BIMCustomerBuilder()
                .firstName("ALok")
                .lastName("Meher")
                .email("alok@invicara.com")
                .billingAddressCompany("Invicara")
                .billingAddressFirstName("Alok")
                .billingAddressLastName("Meher")
                .billingAddressLine1("Eldams Road")
                .billingAddressCity("Chennai")
                .billingAddressState("Tamilnadu")
                .billingAddressStateCode("6200018")
                .company("Invicara")
                .allowDirectDebit(Boolean.TRUE)
                .phone("9940242718")
                .build();
        
        repository.setCustomer(customer);
        
        Optional<Customer> optional = repository.create();
        optional.ifPresent(c -> {
            System.out.println(c.id());
        });

    }

    @Override
    public void getById() {
        String id = "IG5ryp3PvMAfk8gpH";
        Customer customer = repository.getById(id).get();
        Assert.assertEquals(id, customer.id());
    }

    @Override
    public void update() {
        String id = "1sjs9cNPvL3Nw5Vx0";
        repository.updateById(id, "Pintu", "Saha");
        Customer customer = repository.getById(id).get();
        Assert.assertEquals("Pintu", customer.firstName());
    }

    @Override
    public void delete() {
        String id = "HtZEwQTPvGWc1O10m7";
        repository.deleteById(id);
        Customer customer = repository.getById(id).get();
        Assert.assertEquals(id, customer.id());
    }
}
