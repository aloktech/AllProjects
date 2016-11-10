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
public final class XMLParser {

    private XMLParser() {
    }

    public static void main(final String[] args) {

        try {
            final SAXParserFactory factory = SAXParserFactory.newInstance();
            final SAXParser parser = factory.newSAXParser();
//            parser.parse(Files.newInputStream(Paths.get("/home/alok/Tools/netbeans8.1_workspace/SampleProject/config/checkstyle.xml"), StandardOpenOption.READ),
            parser.parse(Files.newInputStream(Paths.get("/home/alok/Tools/netbeans8.1_workspace/SampleProject/pom.xml"), StandardOpenOption.READ),
//            parser.parse(Files.newInputStream(Paths.get("config/checkstyle.xml"), StandardOpenOption.READ),
//            parser.parse(Files.newInputStream(Paths.get("src/main/resources/others.xml"), StandardOpenOption.READ),
//            parser.parse(Files.newInputStream(Paths.get("src/main/resources/google.xml"), StandardOpenOption.READ),
                    new Parser());
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class Parser extends DefaultHandler {

    int count = 0, depth = 0;

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);

        if (qName.equals("module")) {
            depth++;
//            switch (depth) {
//                case 1:
//                    System.out.println("*");
//                    break;
//                case 2:
//                    System.out.println("**");
//                    break;
//                case 3:
//                    System.out.println("***");
//                    break;
//                case 4:
//                    System.out.println("****");
//                    break;
//                default:
//                    break;
//            }
//            System.out.println(qName + " : " + attributes.getValue(attributes.getIndex("name")));
            count++;
        } else if (!qName.equals("property")){
//            System.out.println("## Error : "+qName);
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("module")) {
            depth--;
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
        System.out.println(e.getLineNumber()+" : "+e.getColumnNumber());
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        super.warning(e); //To change body of generated methods, choose Tools | Templates.
        System.out.println(e.getLineNumber()+" : "+e.getColumnNumber());
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        super.fatalError(e); //To change body of generated methods, choose Tools | Templates.
        System.out.println(e.getLineNumber()+" : "+e.getColumnNumber());
    }
    
    
}
