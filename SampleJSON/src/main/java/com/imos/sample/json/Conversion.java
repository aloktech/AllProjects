/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Pintu
 */
public class Conversion {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        String path;
        path = "F:\\Tools\\Netbeans8.1Workspace\\RaspberryPiServer\\Backup\\";
        searchAndParse(mapper, path);
    }

    private static void convertFile(ObjectMapper mapper, String path) throws JSONException, IOException {
        List<String> allData = new ArrayList<>();
        System.out.println(path);
        for (TimeTempHumidData data : mapper.readValue(new File(path), TimeTempHumidData[].class)) {
            data.setDate(Instant.ofEpochMilli(data.getTime()).atZone(ZoneId.systemDefault()).toLocalDate().toString());
            System.out.println(mapper.writeValueAsString(data) + " : " + new Date(data.getTime()));
            allData.add(new JSONObject(mapper.writeValueAsString(data)).toString());
        }
        Files.write(Paths.get(path), allData.toString().getBytes(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);
        System.out.println();
    }

    private static void searchAndParse(ObjectMapper mapper, String filePath) {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(filePath))) {
            for (Path path : directoryStream) {
                if (path.toFile().isFile() && path.toFile().getName().endsWith(".json")) {
                    try {
                        convertFile(mapper, path.toFile().getAbsolutePath());
                    } catch (IOException | JSONException e) {
                    }
                } else if (path.toFile().isDirectory()) {
                    searchAndParse(mapper, path.toFile().getAbsolutePath());
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
