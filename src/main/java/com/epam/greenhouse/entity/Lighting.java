package com.epam.greenhouse.entity;

import javax.xml.bind.annotation.*;

@XmlType(name = "lighting")
@XmlEnum
public enum Lighting {
    SHINE, SHADOW, PENUMBRA
}
