package com.epam.greenhouse.entity;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "growing-conditions", propOrder = {
        "lighting",
        "temperature",
        "watering"
})
public class GrowingConditions {

    @XmlElement(namespace = "http://www.epam.com/greenhouse", required = true)
    @XmlSchemaType(name = "string")
    private Lighting lighting;

    @XmlElement(namespace = "http://www.epam.com/greenhouse", required = true)
    private int temperature;

    @XmlElement(namespace = "http://www.epam.com/greenhouse", required = true)
    private int watering;

    public GrowingConditions() {
    }

    public GrowingConditions(Lighting lighting, int temperature, int watering) {
        this.lighting = lighting;
        this.temperature = temperature;
        this.watering = watering;
    }

    public Lighting getLighting() {
        return lighting;
    }

    public void setLighting(Lighting lighting) {
        this.lighting = lighting;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getWatering() {
        return watering;
    }

    public void setWatering(int watering) {
        this.watering = watering;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GrowingConditions that = (GrowingConditions) o;
        return temperature == that.temperature &&
                watering == that.watering &&
                lighting == that.lighting;
    }

    @Override
    public int hashCode() {
        int result = lighting != null ? lighting.hashCode() : 0;
        result = 31 * result + temperature;
        result = 31 * result + watering;
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "lighting=" + lighting +
                ", temperature=" + temperature +
                ", watering=" + watering +
                '}';
    }
}
