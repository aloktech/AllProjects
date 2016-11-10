/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invicara.chargebee;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author alok
 */
public final class JSONKeysMgmt {

    /**
     *
     */
    private JSONKeysMgmt() {
    }

    /**
     *
     * @param args
     */
    public static void main(final String[] args) {
        manageJSONKeys();
        
        collectUniqueKeys();
    }

    /**
     *
     */
    private static void collectUniqueKeys() {
        Set<String> keySet = new TreeSet<>();
        Path dirPath = Paths.get("src/main/resources/chargebee");
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(dirPath)) {
            for (Path path : directoryStream) {
                try {
                    String str = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
                    if (str.contains("{") && str.contains("}")) {
                        str = str.substring(str.indexOf("{"), str.indexOf("}") + 1);
                        keySet.addAll(new ArrayList<>(new JSONObject(str).keySet()));
                    }
                } catch (JSONException | IOException e) {
                }
            }
            Files.write(Paths.get("src/main/resources/chargebee/keys.txt"), keySet,
                    StandardOpenOption.CREATE);
        } catch (IOException ex) {
        }
    }

    /**
     *
     */
    private static void manageJSONKeys() {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get("src/main/resources/chargebee"))) {
            for (Path path : directoryStream) {
                try {
                    String str = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
                    if (str.contains("{") && str.contains("}")) {
                        str = str.substring(str.indexOf("{"), str.lastIndexOf("}") + 1);
                        Files.delete(path);
                        Files.write(path, (str + "\n").getBytes(),
                                StandardOpenOption.CREATE_NEW);
                        Files.write(path, new TreeSet<>(new JSONObject(str).keySet()), 
                                StandardCharsets.UTF_8,
                                StandardOpenOption.APPEND);
                    }
                } catch (JSONException | IOException e) {
                }
            }
        } catch (IOException ex) {
        }
    }
}
