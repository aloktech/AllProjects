/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author Pintu
 */
public class ManageJSON {

    public static void main(String[] args) {

        ObjectMapper MAPPER = new ObjectMapper();
        Arrays.asList(new File("src/main/resources/Backup").listFiles()).forEach(f -> {
            try {
                Files.write(Paths.get(f.getAbsolutePath()), Arrays.asList(MAPPER.readValue(f.getAbsoluteFile(), TimeTempHumidData[].class))
                        .stream()
                        .sorted((d1, d2) -> Long.compare(d1.getTime(), d2.getTime()))
                        .distinct()
                        .collect(Collectors.toList()).toString().getBytes(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE_NEW);
            } catch (IOException ex) {
                Logger.getLogger(ManageJSON.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}
