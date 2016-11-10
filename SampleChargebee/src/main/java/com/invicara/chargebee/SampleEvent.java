/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee;

import com.chargebee.Environment;
import com.chargebee.ListResult;
import com.chargebee.filters.enums.SortOrder;
import com.chargebee.models.Event;
import com.chargebee.models.enums.Source;
import java.io.IOException;
import java.sql.Timestamp;

/**
 *
 * @author INVCH018
 */
public class SampleEvent {

    public static void main(String[] args) throws IOException {
        Environment.configure("imos-test", "test_dpUemkTT0qmzCF8DCi6H6PZ7owM9stWO");
        ListResult result = Event.list()
                .limit(5)
                .startTime(new Timestamp(1349029800))
                .endTime(new Timestamp(1349116200))
                .id().isNot("1sjs9n8PuDtuD62oqM")
                .source().isNot(Source.HOSTED_PAGE)
                .sortByOccurredAt(SortOrder.ASC).request();
        result.stream().forEach((entry) -> {
            Event event = entry.event();
        });
    }
}
