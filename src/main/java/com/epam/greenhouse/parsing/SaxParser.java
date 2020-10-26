package com.epam.greenhouse.parsing;

import com.epam.greenhouse.entity.AbstractFlower;
import com.epam.greenhouse.parsing.sax.GreenhouseHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class SaxParser implements Parser {

    @Override
    public List<AbstractFlower> parse(String fileName) throws IOException, ParseException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        GreenhouseHandler handler = new GreenhouseHandler();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(fileName, handler);
        } catch (SAXException | ParserConfigurationException e) {
            throw new ParseException(e);
        }
        return handler.getFlowers();
    }
}
