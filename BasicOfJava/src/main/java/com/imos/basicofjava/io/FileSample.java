/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.basicofjava.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author INVCH018
 */
public class FileSample {
    public static void main(String[] args) {
        try {
            LineNumberReader reader = new LineNumberReader(new FileReader(""));
            reader.readLine();
            reader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileSample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileSample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
