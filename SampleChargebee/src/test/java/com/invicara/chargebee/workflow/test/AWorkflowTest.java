/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee.workflow.test;

import com.chargebee.Environment;
import com.chargebee.models.Addon;
import com.chargebee.models.Card;
import com.chargebee.models.Coupon;
import com.chargebee.models.Customer;
import com.chargebee.models.Estimate;
import com.chargebee.models.Invoice;
import com.chargebee.models.Plan;
import com.chargebee.models.Subscription;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.invicara.chargebee.model.BIMAddon;
import com.invicara.chargebee.model.BIMCard;
import com.invicara.chargebee.model.BIMCoupon;
import com.invicara.chargebee.model.BIMCustomer;
import com.invicara.chargebee.model.BIMEstimate;
import com.invicara.chargebee.model.BIMInvoice;
import com.invicara.chargebee.model.BIMPlan;
import com.invicara.chargebee.model.BIMSubscription;
import com.invicara.chargebee.repository.AddonRepository;
import com.invicara.chargebee.repository.CardRepository;
import com.invicara.chargebee.repository.CouponRepository;
import com.invicara.chargebee.repository.CustomerRepository;
import com.invicara.chargebee.repository.EstimateRepository;
import com.invicara.chargebee.repository.InvoiceRepository;
import com.invicara.chargebee.repository.PlanRepository;
import com.invicara.chargebee.repository.SubscriptionRepository;
import java.util.Arrays;
import java.util.Optional;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author alok
 */
public class AWorkflowTest {

    private static Injector injector;
    private String customerId;
    private String subscriptionId;

    private final PlanRepository planRepository = injector.getInstance(PlanRepository.class);
    private final AddonRepository addonRepository = injector.getInstance(AddonRepository.class);
    private final CustomerRepository customerRepository = injector.getInstance(CustomerRepository.class);
    private final CouponRepository couponRepository = injector.getInstance(CouponRepository.class);
    private final SubscriptionRepository subscriptionRepository = injector.getInstance(SubscriptionRepository.class);
    private final InvoiceRepository invoiceRepository = injector.getInstance(InvoiceRepository.class);
    private final CardRepository cardRepository = injector.getInstance(CardRepository.class);
    private final EstimateRepository estimateRepository = injector.getInstance(EstimateRepository.class);

    @BeforeClass
    public static void setUp() {
        injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {

            }
        });
        Environment.configure("imos-test", "test_dpUemkTT0qmzCF8DCi6H6PZ7owM9stWO");
    }

    @Test
    public void configuration() {
        // Plan
        BIMPlan plan = new BIMPlan.BIMPlanBuilder()
                .id("free-trial")
                .name("Free Trial")
                .invoiceName("Free Trial Plan")
                .build();
        planRepository.setPlan(plan);
        Optional<Plan> opPlan = planRepository.create();
        opPlan.ifPresent(p -> {
            System.out.println(p);
        });
        
        // Addon
        BIMAddon addon = new BIMAddon.BIMAddonBuilder()
                    .id("premium_pack")
                    .name("Premium Pack")
                    .invoiceName("BIM Premium Pack")
                    .chargeType(Addon.ChargeType.NON_RECURRING)
                    .price(200)
                    .period(1)
                    .periodUnit(Addon.PeriodUnit.MONTH)
                    .type(Addon.Type.ON_OFF)
                .build();

        addonRepository.setAddon(addon);
        Optional<Addon> opAddon = addonRepository.create();
        opAddon.ifPresent(a -> {
            System.out.println(a);
        });
        
        // Coupon
        BIMCoupon coupon = new BIMCoupon.BIMCouponBuilder()
                .id("bim_sample_offer")
                .name("BIM Sample Offer")
                .discountAmmount(500)
                .build();

        couponRepository.setCoupon(coupon);
        Optional<Coupon> opCoupon = couponRepository.create();
        opCoupon.ifPresent(c -> {
            System.out.println(c);
        });
        
        // Customer
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
        
        customerRepository.setCustomer(customer);
        
        Optional<Customer> opCustomer = customerRepository.create();
        opCustomer.ifPresent(c -> {
            System.out.println(c);
            customerId = c.id();
        });
        
        // Card
        BIMCard card = new BIMCard.BIMCardBuilder()
                .customerId(customerId)
                .firstName("Alok")
                .lastName("Meher")
                .number("4012888888881881")
                .expireMonth(1)
                .expireYear(2017)
                .cvv("713")
                .build();

        cardRepository.setCard(card);
        Optional<Card> opCard = cardRepository.create();
        opCard.ifPresent(c -> {
            System.out.println(c);
        });
        
        
        // Subscription
        BIMSubscription subscription = new BIMSubscription.BIMSubscriptionBuilder()
                .customerId(customerId)
                .planId("free-trial")
                .addons(Arrays.asList("premium_pack"))
                .coupons(Arrays.asList("bim_sample_offer"))
                .build();
        subscriptionRepository.setSubscription(subscription);

        Optional<Subscription> op = subscriptionRepository.createForCustomerId();
        op.ifPresent((s) -> {
            System.out.println(s);
            subscriptionId = s.id();
        });
        
        //Invoice
        BIMInvoice invoice = new BIMInvoice.BIMInvoiceBuilder()
                .customerId(customerId)
                .chargeAmount(1000)
                .chargeDescription("Support charge")
                .build();

        invoiceRepository.setInvoice(invoice);
        Optional<Invoice> optional = invoiceRepository.create();
        optional.ifPresent(c -> {
            System.out.println(c);
        });
        
        // Estimate
        BIMEstimate estimate = new BIMEstimate.BIMEstimateBuilder()
                .subscriptionPlanId("free-trial")
                .build();

        estimateRepository.setEstimate(estimate);
        Optional<Estimate> opEstimate = estimateRepository.create();
        opEstimate.ifPresent(e -> {
            System.out.println(e);
        });
    }
}
