package com.epam.greenhouse.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "inflorescence")
@XmlEnum
public enum Inflorescence {
    SINGLE, BUSH, COMPLEX
}
