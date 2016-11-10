/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.basicofjava.time;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;

/**
 *
 * @author alok
 */
public class SampleTime {

    public static void main(String[] args) {
        System.out.println(new Date());
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTime.now().getDayOfMonth());
        System.out.println(LocalDateTime.now().getDayOfWeek());
        System.out.println(LocalDateTime.now().getDayOfYear());
        System.out.println(LocalDateTime.now().getHour());
        System.out.println(LocalDateTime.now().getMinute());
        System.out.println(LocalDateTime.now().getMonth());
        System.out.println(LocalDateTime.now().getLong(ChronoField.CLOCK_HOUR_OF_AMPM));

        System.out.println("");
        LocalDateTime now = LocalDateTime.now();
        for (ChronoField field : ChronoField.values()) {
            try {
                System.out.println(field.name() + " : " + now.getLong(field));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        System.out.println("");
        System.out.println(LocalDateTime.of(2016, Month.SEPTEMBER, 19, 0, 0));

        String sd = now.withDayOfMonth(1)
                .atZone(ZoneId.of("Europe/Paris"))
                .plus(Duration.ofDays(5))
                .format(DateTimeFormatter.ISO_ZONED_DATE_TIME);

        System.out.println(sd);
    }
}
