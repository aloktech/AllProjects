/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee;

import com.chargebee.Environment;
import com.chargebee.Result;
import com.chargebee.models.Comment;
import com.chargebee.models.enums.EntityType;
import java.io.IOException;

/**
 *
 * @author INVCH018
 */
public class SampleComment {

    public static void main(String[] args) throws IOException {
        Environment.configure("imos-test", "test_dpUemkTT0qmzCF8DCi6H6PZ7owM9stWO");

        Result result = Comment.create()
                .entityId("1sjs9n8PuDtuD62oqM")
                .entityType(EntityType.SUBSCRIPTION)
                .notes("This is a test comment")
                .request();
        Comment comment = result.comment();
        System.out.println(comment);
    }
}
