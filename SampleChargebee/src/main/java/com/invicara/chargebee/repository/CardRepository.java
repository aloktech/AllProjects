/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee.repository;

import com.chargebee.Result;
import com.chargebee.models.Card;
import com.chargebee.models.enums.Gateway;
import com.invicara.chargebee.common.AbstractRepository;
import com.invicara.chargebee.common.Repository;
import com.invicara.chargebee.model.BIMCard;
import java.util.Optional;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

/**
 *
 * @author alok
 */
@Log
public class CardRepository extends AbstractRepository implements Repository<Card> {

    @Getter
    @Setter
    private BIMCard card;

    @Override
    public Optional<Card> create() {
        try {
            Result result = Card.updateCardForCustomer(card.getCustomerId())
                    .gateway(Gateway.CHARGEBEE)
                    .firstName(setStringValue(card.getFirstName()))
                    .lastName(setStringValue(card.getLastName()))
                    .number(setStringValue(card.getNumber()))
                    .expiryMonth(setIntegerValue(card.getExpireMonth()))
                    .expiryYear(setIntegerValue(card.getExpireYear()))
                    .cvv(setStringValue(card.getCvv()))
                    .request();
            log.info(setMessage("Creation of Card is successful", null));
            return Optional.of(result.card());
        } catch (Exception e) {
            log.severe(setMessage("Creation of Card failed due to %s", e));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Card> getById(String id) {
        try {
            Result result = Card.retrieve(id).request();
            return Optional.of(result.card());
        } catch (Exception e) {
            log.severe(setMessage("Get a Card failed due to %s", e));
        }
        return Optional.empty();
    }

    @Override
    public boolean updateById(String id, String... value) {
//        try {
//            Result result = Card.update(id)
//                    .invoiceName(value[0])
//                    .request();
//            Card plan = result.plan();
//            return plan != null;
//        } catch (Exception e) {
//            log.severe(setMessage("Update a Card failed due to %s", e));
//        }
        return true;
    }

    @Override
    public boolean deleteById(String id) {
////        try {
//            Result result = Card.delete(id)
//                    .request();
//            Card plan = result.plan();
//            return plan != null;
//        } catch (Exception e) {
//            log.severe(setMessage("Deleting a Card failed due to %s", e));
//        }
        return false;
    }

}
