package com.mitya;

import exception.DigitBracketException;
import exception.DuoBracketException;
import exception.LatinException;
import exception.SpaceException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnPackerTest {

    @Test
    public void getStringTest() {
        UnPacker up = new UnPacker();
        Assert.assertEquals("2[xy]3[ab]", up.getString());
    }

    @Test
    public void stringTest() {
        String result = "";
        String string = "ab";
        int s1 = 100000;
        long start = System.currentTimeMillis();
        while (s1 > 0) {
            result = result + string;
            s1--;
        }
        long finish = System.currentTimeMillis();
        System.out.println(result);
        System.out.println("Время исполнения цикла " + (finish - start));
    }

    @Test
    public void stringBuilderTest() {
        StringBuilder result = new StringBuilder();
        String string = "ab";
        int s1 = 100000;
        long start = System.currentTimeMillis();
        while (s1 > 0) {
            result.append(string);
            s1--;
        }
        long finish = System.currentTimeMillis();
        System.out.println(result);
        System.out.println("Время исполнения цикла " + (finish - start));
    }

    @Test
    public void multiplyTest() {
        UnPacker up = new UnPacker();
        String actual = up.multiply("10[xyz]");
        Assert.assertEquals("xyzxyzxyzxyzxyzxyzxyzxyzxyzxyz",actual);
    }

    @Test
    public void unpackTest() throws DigitBracketException, LatinException, SpaceException, DuoBracketException {
        UnPacker up = new UnPacker();
        String actual = up.unpackString();
        Assert.assertEquals("xydfdfdfxydfdfdf",actual);
    }

    @Test
    public void testTest(){
        String string = "2[dsz]";
        String SC_REGEX = ".*\\[.*";
        Assert.assertEquals(true,string.matches(SC_REGEX));
    }
}