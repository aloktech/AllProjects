/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.basicofjava.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alok
 */
public class FileList {

    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger();
        try {
//            Files.readAllLines(Paths.get("src/main/resources/aa.txt"))
            Files.readAllLines(Paths.get("src/main/resources/list.txt"))
                    .stream()
                    .filter(line -> !line.trim().isEmpty())
                    .forEach((line) -> {
//                        System.out.println(line.substring(0, line.indexOf("	")) + " : " + line.substring(line.indexOf("	") + 1));
                        if (line.endsWith("::")) {
                            System.out.println("");
                        }
                        System.out.println(line);
                        if (!line.contains("::")) {
                            count.incrementAndGet();
                        }
                    });
            System.out.println(count.get());
        } catch (IOException ex) {
            Logger.getLogger(FileList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
