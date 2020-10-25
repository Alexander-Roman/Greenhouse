package com.epam.greenhouse.validator;

import org.xml.sax.SAXException;

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
    private final String xsdFileName;

    public ValidatorSaxXsd(String xsdFileName) {
        this.xsdFileName = xsdFileName;
    }

    public boolean isValid(String xmlFileName) throws IOException {
        try {
            validate(xmlFileName);
        } catch (SAXException e) {
            return false;
        }
        return true;
    }

    private void validate(String xmlFileName) throws SAXException, IOException {
        SchemaFactory factory = SchemaFactory.newInstance(LANGUAGE);
        File schemaLocation = new File(xsdFileName);
        Schema schema = factory.newSchema(schemaLocation);
        Validator validator = schema.newValidator();
        Source source = new StreamSource(xmlFileName);
        validator.validate(source);
    }
}
