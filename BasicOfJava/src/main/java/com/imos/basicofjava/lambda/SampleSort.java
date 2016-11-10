/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.basicofjava.lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;

/**
 *
 * @author INVCH018
 */
public class SampleSort {
    
    public static void main(String[] args) {
        Path path= Paths.get("src/main/resources/thirdpartysoftware.json");
        StringBuilder builder = new StringBuilder();
        try {
            Files.lines(path).forEach(s->{builder.append(s);});
            JSONArray data = new JSONArray(builder.toString());
            List<String> openSources = new ArrayList<>();
            for (int index = 0; index < data.length(); index++) {
                openSources.add(data.getJSONObject(index).getString("moduleName"));
            }
            openSources.stream().sorted().forEach(System.out::println);
        } catch (IOException ex) {
            Logger.getLogger(SampleSort.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
