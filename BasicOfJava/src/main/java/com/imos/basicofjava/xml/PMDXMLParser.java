/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.basicofjava.xml;

/**
 *
 * @author alok
 */
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import lombok.Getter;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author alok
 */
public final class PMDXMLParser {

    private PMDXMLParser() {
    }

    public static void main(final String[] args) {
        System.out.println("Start");
        StringBuilder builder = new StringBuilder();
        int count = 0;
        PMDCheckStyleParser pmdParser;
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get("src/main/resources/pmd"))) {
            for (Path path : directoryStream) {
                try {
                    final SAXParserFactory factory = SAXParserFactory.newInstance();
                    final SAXParser parser = factory.newSAXParser();
                    pmdParser = new PMDCheckStyleParser(builder);
                    parser.parse(Files.newInputStream(path, StandardOpenOption.READ),
                            pmdParser);
                    count += pmdParser.getCount();
                } catch (ParserConfigurationException | SAXException | IOException ex) {
                    System.out.println(path.getFileName().toString());
                }
            }
        } catch (IOException ex) {
        }
        try {
            builder.append(count);
            builder.append("\n");
                    
            Files.write(Paths.get("src/main/resources/pmd.txt"), builder.toString().getBytes(), StandardOpenOption.CREATE);
        } catch (IOException ex) {
        }
    }
}

class PMDCheckStyleParser extends DefaultHandler {
    @Getter
    int count = 0;
    int depth = 0;

    final StringBuilder builder;

    public PMDCheckStyleParser(StringBuilder builder) {
        this.builder = builder;
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);

        switch (qName) {
            case "rule":
                count++;
            case "ruleset":
            case "property":
                depth++;
                print(attributes);
                break;
            default:
                break;
        }
    }

    private void print(Attributes attributes) {
        String line;
        switch (depth) {
            case 2:
                System.out.print(" ");
                line = "  ";
                break;
            case 3:
                System.out.print("   ");
                line = "    ";
                break;
            default:
                line = "";
                break;
        }
        line += attributes.getValue(attributes.getIndex("name"));
        System.out.println(line);
        builder.append(line);
        builder.append("\n");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "ruleset":
                System.out.println(count + "\n");
                builder.append(count);
                builder.append("\n\n");
                depth--;
                break;
            case "rule":
            case "property":
                depth--;
                break;
            default:
                break;
        }
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        super.error(e);
        System.out.println(e.getLineNumber() + " : " + e.getColumnNumber());
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        super.warning(e);
        System.out.println(e.getLineNumber() + " : " + e.getColumnNumber());
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        super.fatalError(e);
        System.out.println(e.getLineNumber() + " : " + e.getColumnNumber());
    }

}
