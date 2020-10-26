package com.epam.greenhouse.parsing;

public class ParserFactory {

    public static Parser createByType(ParserType parserType) {
        switch (parserType) {
            case SAX:
                return new SaxParser();
            case DOM:
                return new DomParser();
            case JAXB:
                return new JaxbParser();
            default:
                throw new IllegalArgumentException(parserType + " is unknown ParserType!");
        }
    }
}
