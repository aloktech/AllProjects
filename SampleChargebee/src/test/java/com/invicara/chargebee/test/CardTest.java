/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee.test;

import com.chargebee.models.Card;
import com.invicara.chargebee.model.BIMCard;
import com.invicara.chargebee.repository.CardRepository;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;

import static com.invicara.chargebee.test.AbstractTest.injector;

/**
 *
 * @author alok
 */
public class CardTest extends AbstractTest<CardRepository> {

    private final CardRepository repository = injector.getInstance(CardRepository.class);

    @Test
    public void test() {
//        create();
        getById();
//        update();
//        delete();
    }

    @Override
    public void create() {
        BIMCard card = new BIMCard.BIMCardBuilder()
                .customerId("IG5ryp3PvMAfk8gpH")
                .firstName("Alok")
                .lastName("Meher")
                .number("4012888888881881")
                .expireMonth(1)
                .expireYear(2017)
                .cvv("713")
                .build();

        repository.setCard(card);
        Optional<Card> optional = repository.create();
        optional.ifPresent(c -> {
            System.out.println(c);
            Assert.assertEquals("Success", "Alok", c.firstName());
        });
    }

    @Override
    public void getById() {
        Optional<Card> optional = repository.getById("IG5ryp3PvMAfk8gpH");
        optional.ifPresent(p -> {
            System.out.println(p);
//            Assert.assertEquals("Success", "free-trial", p);
        });
    }

    @Override
    public void update() {
        boolean status = repository.updateById("free-trial", "Free Trial Plan A");
        Assert.assertTrue(status);
        Optional<Card> optional = repository.getById("free-trial");
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
