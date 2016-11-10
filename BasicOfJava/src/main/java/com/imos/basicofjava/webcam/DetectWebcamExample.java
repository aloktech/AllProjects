/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.basicofjava.webcam;

import com.github.sarxos.webcam.Webcam;

/**
 *
 * @author INVCH018
 */
public class DetectWebcamExample {

    public static void main(String[] args) {
        Webcam webcam = Webcam.getDefault();
        if (webcam != null) {
            System.out.println("Webcam: " + webcam.getName());
        } else {
            System.out.println("No webcam detected");
        }
    }
}
