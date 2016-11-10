/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.basicofjava.webcam;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author INVCH018
 */
public class CustomResolutionExample {

    public static void main(String[] args) throws IOException {

        /**
         * When you set custom resolutions you have to be sure that your webcam
         * device will handle them!
         */
        //@formatter:off
        Dimension[] nonStandardResolutions = new Dimension[]{
            WebcamResolution.PAL.getSize(),
            WebcamResolution.HD720.getSize(),
            new Dimension(2000, 1000),
            new Dimension(1000, 500),};
        //@formatter:on

        // your camera have to support HD720p to run this code
        Webcam webcam = Webcam.getDefault();
        webcam.setCustomViewSizes(nonStandardResolutions);
        webcam.setViewSize(WebcamResolution.HD720.getSize());
        webcam.open();

        BufferedImage image = webcam.getImage();

        System.out.println(image.getWidth() + "x" + image.getHeight());
        ImageIO.write(webcam.getImage(), "PNG", new File("hello-world-hd.png"));
    }

}
