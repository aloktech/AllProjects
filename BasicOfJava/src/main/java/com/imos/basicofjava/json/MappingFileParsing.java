/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.basicofjava.json;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author alok
 */
public class MappingFileParsing {
    
    public static void main(String[] args) {
        
        try {
            String data = new String(Files.readAllBytes(Paths.get("src/main/resources/mappings.json")), StandardCharsets.UTF_8);
            JSONObject json = new JSONObject(data);
            JSONArray array = json.getJSONObject("pivot").getJSONArray("mappings");
            for (int index = 0, n = array.length(); index < n; index++) {
                System.out.println(array.getJSONObject(index).getInt("columnIndex"));
            }
        } catch (IOException ex) {
            Logger.getLogger(MappingFileParsing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
