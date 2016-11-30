/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * CheckJSONData.
 *
 * @author Pintu
 */
public final class CheckJSONData {

    /**
     * CheckJSONData.
     */
    private CheckJSONData() {
    }
    
    /**
     * main method.
     * @param args 
     */
    public static void main(final String[] args) {
        ObjectMapper MAPPER = new ObjectMapper();
        String baseFolder = "F:\\Tools\\Netbeans8.1Workspace\\RaspberryPiServer\\Backup\\";
        List<TimeTempHumidData> dayList = new ArrayList<>();
        JsonNode array;
        try {
            LocalDate date = Instant.ofEpochMilli(System.currentTimeMillis()).atZone(ZoneId.systemDefault()).toLocalDate();
            array = MAPPER.readValue(new File(baseFolder + date.getDayOfMonth() + "_" + date.getMonth().getValue() + "_" + date.getYear() + ".json"), JsonNode.class);
            Iterator<JsonNode> itr = array.iterator();
            while (itr.hasNext()) {
                JsonNode node = itr.next();
                System.out.println(MAPPER.writeValueAsString(node));
                System.out.println(MAPPER.readValue(MAPPER.writeValueAsString(node), TimeTempHumidData.class));
                dayList.add(MAPPER.readValue(MAPPER.writeValueAsString(node), TimeTempHumidData.class));
                break;
            }
            System.out.println(dayList.size());
        } catch (IOException ex) {
            Logger.getLogger(CheckJSONData.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            LocalDate date = Instant.ofEpochMilli(System.currentTimeMillis()).atZone(ZoneId.systemDefault()).toLocalDate();
            TimeTempHumidData[] arrays = MAPPER.readValue(new File(baseFolder + date.getDayOfMonth() + "_" + date.getMonth().getValue() + "_" + date.getYear() + ".json"), TimeTempHumidData[].class);
            dayList = Arrays.asList(arrays);
            System.out.println(arrays[0]);
            System.out.println(arrays.length);
            System.out.println(dayList.size());
        } catch (IOException ex) {
            Logger.getLogger(CheckJSONData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
