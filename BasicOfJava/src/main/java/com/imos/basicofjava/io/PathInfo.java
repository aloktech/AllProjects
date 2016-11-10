/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.basicofjava.io;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author INVCH018
 */
// Class to illustrate how to use Path interface and its methods
public final class PathInfo {

    /**
     *
     */
    private PathInfo() {
    }

    /**
     *
     * @param args
     */
    public static void main(final String[] args) {
// create a Path object by calling static method get() in Paths class
        Path testFilePath = Paths.get("D:\\test\\testfile.txt");
// retrieve basic information about path
        System.out.println("Printing file information: ");
        System.out.println("\t file name: " + testFilePath.getFileName());
        System.out.println("\t root of the path: " + testFilePath.getRoot());
        System.out.println("\t parent of the target: " + testFilePath.getParent());
// print path elements
        System.out.println("Printing elements of the path: ");
        for (Path element : testFilePath) {
            System.out.println("\t path element: " + element);
        }
    }
}
