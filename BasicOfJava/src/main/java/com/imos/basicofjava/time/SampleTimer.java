/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.basicofjava.time;

import java.time.LocalTime;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import lombok.Builder;
import lombok.Getter;

/**
 *
 * @author alok
 */
public class SampleTimer {

    public static void main(String args[]) throws InterruptedException {

        Schedule schedule = new Schedule.ScheduleBuilder()
                .milliSecond("*")
                .second("*")
                .minute("2")
                .build();

        Timer time = new Timer(); // Instantiate Timer Object
        ScheduledTask st = new ScheduledTask(); // Instantiate SheduledTask class
        time.schedule(st, 0, getDelayTime(schedule)); // Create Repetitively task for every 1 secs

        System.out.println(LocalTime.now().getMinute());
        System.out.println(LocalTime.now().getMinute() > 59);
        while (true) {
            if (LocalTime.now().getMinute() > 59) {
                st.cancel();
                time.cancel();
                break;
            }
        }
        System.out.println("end");
    }

    static long getDelayTime(Schedule schedule) {
        long secondTime = 1000L;
        long time = 0;
        if (!schedule.getMilliSecond().equals("0")) {
            time += schedule.getMilliSecond().equals("*") ? 
                    0 : Long.parseLong(schedule.getMilliSecond());
        }
        if (!schedule.getSecond().equals("0")) {
            time += secondTime * (schedule.getSecond().equals("*") ? 
                    0 : Long.parseLong(schedule.getSecond()));
        }
        if (!schedule.getMinute().equals("0")) {
            time += secondTime * 60 * (schedule.getMinute().equals("*") ? 
                    0 : Long.parseLong(schedule.getMinute()));
        }
        if (!schedule.getHour().equals("0")) {
            time += secondTime * 60 * 60 *(schedule.getHour().equals("*") ? 
                    0 : Long.parseLong(schedule.getHour()));
        }
        return time;
    }
}

@Builder
@Getter
class Schedule {
    
    /**
     * 
     */
    private final String milliSecond;
    
    private final String second;

    private final String minute;

    private final String hour;

    private final String dayOfMonth;

    private final String month;

    private final String dayOfWeek;

    private final String year;

    private final String timezone;

    private final String info;

    private final boolean persistent;

    public Schedule(String milliSecond, 
            String second, 
            String minute, 
            String hour, 
            String dayOfMonth, 
            String month, 
            String dayOfWeek, 
            String year, 
            String timezone, 
            String info, 
            boolean persistent) {
        
        this.milliSecond = milliSecond == null ? "0" : milliSecond;
        this.second = second == null ? "0" : second;
        this.minute = minute == null ? "0" : minute;
        this.hour = hour == null ? "0" : hour;
        this.dayOfMonth = dayOfMonth == null ? "*" : dayOfMonth;
        this.month = month == null ? "*" : month;
        this.dayOfWeek = dayOfWeek == null ? "*" : dayOfWeek;
        this.year = year == null ? "" : year;
        this.timezone = timezone == null ? "" : timezone;
        this.info = info == null ? "" : info;
        this.persistent = persistent;
    }
    
    /**
     * 
     */
    public static class ScheduleBuilder {
        
        /**
         * 
         */
        public ScheduleBuilder() {}
    }
}

class ScheduledTask extends TimerTask {

    Date now; // to display current time

    // Add your task here
    @Override
    public void run() {
        System.out.println("Time is :" + LocalTime.now()); // Display current time
    }
}
