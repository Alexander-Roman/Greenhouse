package com.epam.greenhouse.validator;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ValidatorSaxXsdTest {

    private static final String XSD_SCHEMA = "src/test/resources/GreenhouseTest.xsd";
    private static final String FILE_CORRECT = "src/test/resources/GreenhouseTest.xml";
    private static final String FILE_XML_CORRUPTED = "src/test/resources/GreenhouseTestXmlCorrupted.xml";
    private static final String FILE_DATA_CORRUPTED = "src/test/resources/GreenhouseTestDataCorrupted.xml";
    private static final String FILE_LOST = "src/test/resources/GreenhouseTestLost.xml";

    private final ValidatorSaxXsd validator = new ValidatorSaxXsd(XSD_SCHEMA);

    @Test
    public void testIsValidShouldReturnTrueWhenFileCorrect() throws IOException {
        //given
        //when
        boolean actual = validator.isValid(FILE_CORRECT);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsValidShouldReturnFalseWhenFileXmlDataCorrupted() throws IOException {
        //given
        //when
        boolean actual = validator.isValid(FILE_XML_CORRUPTED);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void testIsValidShouldReturnFalseWhenFileDataCorrupted() throws IOException {
        //given
        //when
        boolean actual = validator.isValid(FILE_DATA_CORRUPTED);
        //then
        Assert.assertFalse(actual);
    }

    @Test(expectedExceptions = IOException.class)
    public void testIsValidShouldThrowIOExceptionWhenFileLost() throws IOException {
        //given
        //when
        boolean actual = validator.isValid(FILE_LOST);
        //then
    }

}
