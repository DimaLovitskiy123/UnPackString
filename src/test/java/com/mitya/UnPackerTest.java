package com.mitya;

import exception.DigitBracketException;
import exception.DuoBracketException;
import exception.LatinException;
import exception.SpaceException;
import org.junit.Assert;
import org.junit.Test;

public class UnPackerTest {

    @Test
    public void unpackTest() throws DigitBracketException, LatinException, SpaceException, DuoBracketException {
        UnPacker up = new UnPacker();
        String actual = up.unpackStringFromFile();
        Assert.assertEquals("xydfdfdfxydfdfdf",actual);
    }
}