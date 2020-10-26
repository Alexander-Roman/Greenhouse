package com.epam.greenhouse.parsing;

import com.epam.greenhouse.entity.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DomParser implements Parser {

    private static final String CUT_FLOWER = "cut-flower";
    private static final String POTTED_FLOWER = "potted-flower";
    private static final String INFLORESCENCE = "inflorescence";
    private static final String BLOOM_ABLE = "bloom-able";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String PRICE = "price";
    private static final String LIGHTING = "lighting";
    private static final String TEMPERATURE = "temperature";
    private static final String WATERING = "watering";

    @Override
    public List<AbstractFlower> parse(String fileName) throws IOException, ParseException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document document;
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(fileName);
        } catch (SAXException | ParserConfigurationException e) {
            throw new ParseException(e);
        }

        return buildAllFlowers(document);
    }

    private List<AbstractFlower> buildAllFlowers(Document document) {
        List<AbstractFlower> flowers = new ArrayList<AbstractFlower>();
        Element greenhouse = document.getDocumentElement();
        NodeList flowersNodeList = greenhouse.getChildNodes();

        for (int i = 0; i < flowersNodeList.getLength(); i++) {
            Node node = flowersNodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element flowerElement = (Element) node;
                AbstractFlower flower = buildFlower(flowerElement);
                flowers.add(flower);
            }
        }
        return flowers;
    }

    private AbstractFlower buildFlower(Element flowerElement) {
        AbstractFlower flower;

        switch (flowerElement.getTagName()) {
            case CUT_FLOWER:
                flower = buildCutFlower(flowerElement);
                break;
            case POTTED_FLOWER:
                flower = buildPottedFlower(flowerElement);
                break;
            default:
                throw new IllegalArgumentException(flowerElement.getTagName() + " is not inherited AbstractFlower from or not defined!");
        }

        String idValue = flowerElement.getAttribute(ID);
        long id = Long.parseLong(idValue);
        flower.setId(id);

        String name = getElementTextContent(flowerElement, NAME);
        flower.setName(name);

        String priceValue = getElementTextContent(flowerElement, PRICE);
        flower.setPrice(new BigDecimal(priceValue));

        GrowingConditions conditions = buildGrowingConditions(flowerElement);
        flower.setConditions(conditions);

        return flower;
    }

    private AbstractFlower buildCutFlower(Element cutFlowerElement) {
        CutFlower cutFlower = new CutFlower();
        String inflorescenceValue = getElementTextContent(cutFlowerElement, INFLORESCENCE);
        Inflorescence inflorescence = Inflorescence.valueOf(inflorescenceValue);
        cutFlower.setInflorescence(inflorescence);
        return cutFlower;
    }

    private AbstractFlower buildPottedFlower(Element pottedFlowerElement) {
        PottedFlower pottedFlower = new PottedFlower();
        String bloomAbleValue = getElementTextContent(pottedFlowerElement, BLOOM_ABLE);
        boolean bloomAble = Integer.parseInt(bloomAbleValue) > 0;
        pottedFlower.setBloomAble(bloomAble);
        return pottedFlower;
    }

    private GrowingConditions buildGrowingConditions(Element flowerElement) {
        GrowingConditions conditions = new GrowingConditions();

        String lightingValue = getElementTextContent(flowerElement, LIGHTING);
        Lighting lighting = Lighting.valueOf(lightingValue);
        conditions.setLighting(lighting);

        String temperatureValue = getElementTextContent(flowerElement, TEMPERATURE);
        int temperature = Integer.parseInt(temperatureValue);
        conditions.setTemperature(temperature);

        String wateringValue = getElementTextContent(flowerElement, WATERING);
        int watering = Integer.parseInt(wateringValue);
        conditions.setWatering(watering);

        return conditions;
    }

    private String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }
}
