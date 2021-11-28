package com.mitya;

import exception.DuoBracketException;
import exception.LatinException;
import exception.SpaceException;
import exception.DigitBracketException;

import org.junit.Test;

public class ValidatorTest {

    @Test(expected = SpaceException.class)
    public void spaceValidationTestN() throws SpaceException {
        Validator.validSpace("2 [sd c]");
    }

    @Test(expected = DuoBracketException.class)
    public void duoBracketValidationTestN() throws DuoBracketException {
        Validator.validDuoBracket("2[sd4f]]");
    }

    @Test(expected = DigitBracketException.class)
    public void digitBracketTestN() throws DigitBracketException {
        Validator.validDigitBracket("2sd3[s]]");
    }

    @Test(expected = LatinException.class)
    public void latinValidationTest1N() throws LatinException{
        Validator.validLatin("2[vв]");
    }

    @Test(expected = LatinException.class)
    public void latinValidationTest2N() throws LatinException{
        Validator.validLatin2("2[vв]");
    }

    @Test(expected = SpaceException.class)
    public void allValidationTestN() throws LatinException, DuoBracketException,
            DigitBracketException, SpaceException {
        Validator.allValidation("2[vn]");
    }

    @Test
    public void spaceValidationTestP() throws SpaceException {
        Validator.validSpace("2[sdc]");
    }

    @Test
    public void duoBracketValidationTestP() throws DuoBracketException {
        Validator.validDuoBracket("2[sd3[s]]");
    }

    @Test
    public void digitBracketValidationTestP() throws DigitBracketException {
        Validator.validDigitBracket("22[sd3[s]]");
    }

    @Test
    public void latinValidationTest1P() throws LatinException{
        Validator.validLatin("2[sd]");
    }

    @Test
    public void latinValidationTest2P() throws LatinException{
        Validator.validLatin2("2[sd]");
    }

    @Test
    public void allValidationTestP() throws LatinException, DuoBracketException,
            DigitBracketException, SpaceException {
        Validator.allValidation("2[sd]");
    }
}