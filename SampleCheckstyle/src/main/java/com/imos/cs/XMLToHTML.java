/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.cs;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author alok
 */
public final class XMLToHTML {

    /**
     * Unused Constructor.
     */
    private XMLToHTML() {
    }

    /**
     * Sample.
     *
     * @param args
     */
    public static void main(final String[] args) {
        String path = "src/main/resources/checkstyle-report.html";
        try (FileOutputStream outputStream = new FileOutputStream(path)) {
            final TransformerFactory factory = TransformerFactory.newInstance();
            path = "src/main/resources/checkstyle-report.xslt";
            final StreamSource source = new StreamSource(Files.newBufferedReader(Paths.get(path)));
            final Transformer transformer = factory.newTransformer(source);
            final StreamResult outputTarget = new StreamResult(outputStream);
            path = "/home/alok/Tools/netbeans8.1_workspace/SampleCheckstyle/target/checkstyle-result.xml";
            final StreamSource xmlSource = new StreamSource(path);

            // Transform the XML Source to a Result
            transformer.transform(xmlSource, outputTarget);
        } catch (IOException | TransformerException ex) {
            Logger.getLogger(XMLToHTML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
