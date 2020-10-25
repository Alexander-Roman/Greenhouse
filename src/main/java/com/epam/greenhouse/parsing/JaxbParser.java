package com.epam.greenhouse.parsing;

import com.epam.greenhouse.entity.AbstractFlower;
import com.epam.greenhouse.entity.Greenhouse;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class JaxbParser implements Parser {

    @Override
    public List<AbstractFlower> parse(String fileName) throws IOException, ParseException {
        Greenhouse greenhouse;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            JAXBContext context = JAXBContext.newInstance(Greenhouse.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            greenhouse = (Greenhouse) unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            throw new ParseException(e);
        }
        return greenhouse.getFlowers();
    }
}
