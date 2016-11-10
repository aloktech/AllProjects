/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sample;

import com.google.inject.AbstractModule;

/**
 *
 * @author INVCH018
 */
public class BillingModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(TransactionLog.class).to(DatabaseTransactionLog.class);
        bind(CreditCardProcessor.class).to(PaypalCreditCardProcessor.class);
        bind(BillingService.class).to(RealBillingService.class);
        bind(PizzaOrder.class).to(PizzaHutOrder.class);
        bind(CreditCard.class).to(CitiBankCreditCard.class);
    }
}
