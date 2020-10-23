package com.epam.greenhouse.parsing;

import com.epam.greenhouse.entity.AbstractFlower;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public interface Parser {

    List<AbstractFlower> parse(String fileName) throws IOException, SAXException, ParserConfigurationException;
}
