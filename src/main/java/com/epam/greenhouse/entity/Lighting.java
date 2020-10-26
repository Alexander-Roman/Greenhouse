package com.epam.greenhouse.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "lighting")
@XmlEnum
public enum Lighting {
    SHINE, SHADOW, PENUMBRA
}
