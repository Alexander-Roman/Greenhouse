package com.epam.greenhouse.parsing;

import com.epam.greenhouse.entity.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public abstract class ParserTest {

    private static final String FILE_CORRECT = "src/test/resources/GreenhouseTest.xml";
    private static final String FILE_XML_CORRUPTED = "src/test/resources/GreenhouseTestXmlCorrupted.xml";
    private static final String FILE_LOST = "src/test/resources/GreenhouseTestLost.xml";

    private final List<AbstractFlower> expected = Arrays.asList(
            new CutFlower(1000, "Hybrid Tea Rose", new GrowingConditions(Lighting.SHINE, 18, 2), new BigDecimal("5.50"), Inflorescence.SINGLE),
            new CutFlower(1001, "Climbing Rose", new GrowingConditions(Lighting.PENUMBRA, 26, 4), new BigDecimal("4.85"), Inflorescence.BUSH),
            new PottedFlower(1002, "Floribunda", new GrowingConditions(Lighting.SHADOW, 20, 1), new BigDecimal("11.65"), false),
            new PottedFlower(1003, "Grandiflora", new GrowingConditions(Lighting.PENUMBRA, 22, 2), new BigDecimal("16.00"), true)
    );
    private Parser parser;

    /* package-private for tests */
    ParserTest() {
    }

    /* package-private for tests */
    ParserTest(Parser parser) {
        this.parser = parser;
    }

    @Test
    public void testParseShouldReturnCorrectList() throws IOException, ParseException {
        //given
        //when
        List<AbstractFlower> actual = parser.parse(FILE_CORRECT);
        //then
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ParseException.class)
    public void testParseShouldThrowParseExceptionWhenFileIsCorrupted() throws IOException, ParseException {
        //given
        //when
        List<AbstractFlower> actual = parser.parse(FILE_XML_CORRUPTED);
        //then
    }

    @Test(expectedExceptions = IOException.class)
    public void testParseShouldThrowIOExceptionWhenFileNameWrong() throws IOException, ParseException {
        //given
        //when
        List<AbstractFlower> actual = parser.parse(FILE_LOST);
        //then
    }

}
