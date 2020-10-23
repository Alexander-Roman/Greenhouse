package com.epam.greenhouse.validator;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ValidatorSaxXsd {

    private static final String LANGUAGE = XMLConstants.W3C_XML_SCHEMA_NS_URI;
    private final String xmlFileName;
    private final String xsdFileName;
    private final DefaultHandler handler;

    public ValidatorSaxXsd(String xmlFileName, String xsdFileName, DefaultHandler handler) {
        this.xmlFileName = xmlFileName;
        this.xsdFileName = xsdFileName;
        this.handler = handler;
    }

    public void validate() throws SAXException, IOException {
        SchemaFactory factory = SchemaFactory.newInstance(LANGUAGE);
        File schemaLocation = new File(xsdFileName);
        Schema schema = factory.newSchema(schemaLocation);
        Validator validator = schema.newValidator();
        Source source = new StreamSource(xmlFileName);
        validator.setErrorHandler(handler);
        validator.validate(source);
    }
}
