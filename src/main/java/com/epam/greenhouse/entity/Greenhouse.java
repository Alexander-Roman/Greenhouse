package com.epam.greenhouse.entity;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "greenhouse", namespace = "http://www.epam.com/greenhouse")
@XmlAccessorType(XmlAccessType.FIELD)
public class Greenhouse {

    @XmlElements({
            @XmlElement(name = "cut-flower", namespace = "http://www.epam.com/greenhouse", type = CutFlower.class),
            @XmlElement(name = "potted-flower", namespace = "http://www.epam.com/greenhouse", type = PottedFlower.class)
    })
    private List<AbstractFlower> flowers;

    public Greenhouse() {
    }

    public List<AbstractFlower> getFlowers() {
        return flowers;
    }

    public void setFlowers(List<AbstractFlower> flowers) {
        this.flowers = flowers;
    }

}
