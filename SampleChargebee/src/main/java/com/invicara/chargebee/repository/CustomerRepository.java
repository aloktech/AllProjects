/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee.repository;

import com.chargebee.Result;
import com.chargebee.models.Customer;
import com.chargebee.models.enums.AutoCollection;
import com.invicara.chargebee.common.AbstractRepository;
import com.invicara.chargebee.common.Repository;
import com.invicara.chargebee.model.BIMCustomer;
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
public class CustomerRepository extends AbstractRepository implements Repository<Customer>{

    @Getter
    @Setter
    private BIMCustomer customer;

    public CustomerRepository() {
    }

    @Override
    public Optional<Customer> create() {
        Result result;
        try {
            result = Customer.create()
                    .firstName(setStringValue(customer.getFirstName()))
                    .lastName(setStringValue(customer.getLastName()))
                    .email(setStringValue(customer.getEmail()))
                    .billingAddressCompany(setStringValue(customer.getBillingAddressCompany()))
                    .billingAddressFirstName(setStringValue(customer.getBillingAddressFirstName()))
                    .billingAddressLastName(setStringValue(customer.getBillingAddressLastName()))
                    .billingAddressLine1(setStringValue(customer.getBillingAddressLine1()))
                    .billingAddressCity(setStringValue(customer.getBillingAddressLine2()))
                    .billingAddressState(setStringValue(customer.getBillingAddressState()))
                    .billingAddressStateCode(setStringValue(customer.getBillingAddressStateCode()))
                    .billingAddressCountry(setStringValue(customer.getBillingAddressCountry()))
                    //                    .cardFirstName("Alok")
                    //                    .cardLastName("Meher")
                    //                    .cardBillingCity("Chennai")
                    //                    .cardBillingState("Tamilnadu")
                    //                    .cardBillingStateCode("6200018")
                    //                    .cardBillingAddr1("Eldams Road")
                    //                    .cardCvv("123")
                    //                    .cardNumber("4386280019181233")
                    //                    .cardExpiryMonth(1)
                    //                    .cardExpiryYear(2017)
                    .company(setStringValue(customer.getCompany()))
                    .allowDirectDebit(Boolean.TRUE)
                    .autoCollection(AutoCollection.ON)
                    //                    .paymentMethodType(Type.PAYPAL_EXPRESS_CHECKOUT)
                    .phone(setStringValue(customer.getPhone()))
                    .request();
            log.info(setMessage("Creation of Customer is successful", null));
            return Optional.of(result.customer());
        } catch (IOException ex) {
            log.severe(setMessage("Creation of Customer failed due to %s", ex));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Customer> getById(String id) {

        Result result;
        try {
            result = Customer.retrieve(id).request();
            return Optional.of(result.customer());
        } catch (IOException ex) {
            Logger.getLogger(CustomerRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Optional.empty();
    }
    
    @Override
    public boolean updateById(String id, String ...value) {

        Result result;
        try {
            result = Customer.update(id)
                    .firstName(value[0])
                    .lastName(value[1])
                    .request();
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
