/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

/**
 *
 * @author Pintu
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Pintu
 */
public class FileAllFilesName {

    public static void main(String[] args) {
        searchAndParse(Paths.get("J:\\"), null);
    }

    private static void searchAndParse(Path folderPath, Object allData) {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(folderPath)) {
            File file;
            for (Path path : directoryStream) {
                file = path.toFile();
                if (file.isFile() && !file.isHidden()) {
//                    System.out.println(path);
                } else if (file.isDirectory() && !file.isHidden()) {
                    System.out.println(path);
                    searchAndParse(path, allData);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
