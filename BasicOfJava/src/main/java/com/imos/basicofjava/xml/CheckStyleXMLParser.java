package com.imos.basicofjava.xml;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author alok
 */
public final class CheckStyleXMLParser {

    private CheckStyleXMLParser() {
    }

    public static void main(final String[] args) {

        try {
            StringBuilder builder = new StringBuilder();
            final SAXParserFactory factory = SAXParserFactory.newInstance();
            final SAXParser parser = factory.newSAXParser();
            CheckStyleParser csParser = new CheckStyleParser(builder);
            parser.parse(Files.newInputStream(Paths.get("src/main/resources/checkstyle/checkstyle.xml"), StandardOpenOption.READ),
                    csParser);

            Files.write(Paths.get("src/main/resources/checkstyle.txt"), builder.toString().getBytes(), StandardOpenOption.CREATE);
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(CheckStyleXMLParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class CheckStyleParser extends DefaultHandler {

    int count = 0, depth = -1;

    final StringBuilder builder;

    public CheckStyleParser(StringBuilder builder) {
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
            case "module":
                count++;
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
            case 1:
                System.out.print(" ");
                line = " ";
                break;
            case 2:
                System.out.print("  ");
                line = "  ";
                break;
            case 3:
                System.out.print("    ");
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
            case "module":
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
        System.out.println(count);
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        super.error(e); //To change body of generated methods, choose Tools | Templates.
        System.out.println(e.getLineNumber() + " : " + e.getColumnNumber());
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        super.warning(e); //To change body of generated methods, choose Tools | Templates.
        System.out.println(e.getLineNumber() + " : " + e.getColumnNumber());
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        super.fatalError(e); //To change body of generated methods, choose Tools | Templates.
        System.out.println(e.getLineNumber() + " : " + e.getColumnNumber());
    }

}
