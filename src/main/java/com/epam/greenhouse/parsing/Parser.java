package com.epam.greenhouse.parsing;

import com.epam.greenhouse.entity.AbstractFlower;

import java.io.IOException;
import java.util.List;

public interface Parser {

    List<AbstractFlower> parse(String fileName) throws IOException, ParseException;
}
