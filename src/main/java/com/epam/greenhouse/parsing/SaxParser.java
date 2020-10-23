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
    public List<AbstractFlower> parse(String fileName) throws IOException, SAXException, ParserConfigurationException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        GreenhouseHandler handler = new GreenhouseHandler();
        parser.parse(fileName, handler);
        return handler.getFlowers();
    }
}
