package com.epam.greenhouse.parsing.sax;

import com.epam.greenhouse.entity.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GreenhouseHandler extends DefaultHandler {

    private static final String GREENHOUSE = "greenhouse";
    private static final String CUT_FLOWER = "cut-flower";
    private static final String POTTED_FLOWER = "potted-flower";
    private static final String INFLORESCENCE = "inflorescence";
    private static final String BLOOM_ABLE = "bloom-able";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String PRICE = "price";
    private static final String GROWING_CONDITIONS = "growing-conditions";
    private static final String LIGHTING = "lighting";
    private static final String TEMPERATURE = "temperature";
    private static final String WATERING = "watering";

    private List<AbstractFlower> flowers;
    private AbstractFlower flower;
    private GrowingConditions conditions;
    private String element;

    public List<AbstractFlower> getFlowers() {
        return flowers;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        switch (qName) {
            case GREENHOUSE:
                flowers = new ArrayList<AbstractFlower>();
                break;
            case CUT_FLOWER:
                flower = new CutFlower();
                setFlowerId(attributes);
                break;
            case POTTED_FLOWER:
                flower = new PottedFlower();
                setFlowerId(attributes);
                break;
            default:
                element = qName;
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (element == null) {
            return;
        }
        switch (element) {
            case NAME:
                String name = String.valueOf(ch, start, length);
                flower.setName(name);
                break;
            case PRICE:
                String priceValue = String.valueOf(ch, start, length);
                flower.setPrice(new BigDecimal(priceValue));
                break;
            case INFLORESCENCE:
                CutFlower cutFlower = (CutFlower) flower;
                String inflorescenceValue = String.valueOf(ch, start, length);
                Inflorescence inflorescence = Inflorescence.valueOf(inflorescenceValue);
                cutFlower.setInflorescence(inflorescence);
                break;
            case BLOOM_ABLE:
                PottedFlower pottedFlower = (PottedFlower) flower;
                String bloomAbleValue = String.valueOf(ch, start, length);
                boolean bloomAble = Integer.parseInt(bloomAbleValue) > 0;
                pottedFlower.setBloomAble(bloomAble);
                break;
            case GROWING_CONDITIONS:
                conditions = new GrowingConditions();
                break;
            case LIGHTING:
                String lightingValue = String.valueOf(ch, start, length);
                Lighting lighting = Lighting.valueOf(lightingValue);
                conditions.setLighting(lighting);
                break;
            case TEMPERATURE:
                String temperatureValue = String.valueOf(ch, start, length);
                int temperature = Integer.parseInt(temperatureValue);
                conditions.setTemperature(temperature);
                break;
            case WATERING:
                String wateringValue = String.valueOf(ch, start, length);
                int watering = Integer.parseInt(wateringValue);
                conditions.setWatering(watering);
                break;
            default:
                break;
        }
    }


    @Override
    public void endElement(String uri, String localName, String qName) {
        switch (qName) {
            case GROWING_CONDITIONS:
                flower.setConditions(conditions);
                conditions = null;
                break;
            case CUT_FLOWER:
            case POTTED_FLOWER:
                flowers.add(flower);
                break;
            default:
                element = null;
                break;
        }
    }

    private void setFlowerId(Attributes attributes) {
        String idValue = attributes.getValue(ID);
        long id = Long.parseLong(idValue);
        flower.setId(id);
    }

}
