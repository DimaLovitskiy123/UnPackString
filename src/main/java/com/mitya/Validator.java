package com.mitya;

import exception.DuoBracketException;
import exception.LatinException;
import exception.SpaceException;
import exception.DigitBracketException;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static final String OPEN_BRACKET = "\\[";
    private static final String CLOSE_BRACKET = "\\]";
    private static final String DIGIT_BRACKET = "\\d+[a-z]";
    private static final String INT_PLUS_BRACKET = "\\d+\\[";

    public static void validSpace(String string) throws SpaceException {
        Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(string);
        if (matcher.find()) {
            throw new SpaceException("В строчке не должно быть пробелов.");
        }
    }

    public static void validDuoBracket(String string) throws DuoBracketException {
        int openCount = 0;
        int closeCount = 0;
        Pattern pattern = Pattern.compile(OPEN_BRACKET);
        Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            openCount++;
        }
        pattern = Pattern.compile(CLOSE_BRACKET);
        matcher = pattern.matcher(string);

        while (matcher.find()) {
            closeCount++;
        }
        if (openCount != closeCount) {
            throw new DuoBracketException("Нарушена парность скобочек.");
        }
    }

    public static void validDigitBracket(String string) throws DigitBracketException {
        Pattern pattern = Pattern.compile(DIGIT_BRACKET);
        Matcher matcher = pattern.matcher(string);
        if (matcher.find()) {
            throw new DigitBracketException("После цифры должна идти скобка.");
        }
    }

    private static char[] getLatin() {
        char[] latin = new char[26];
        int z = 0;
        for (char w = 97; w < 123; w++) {
            latin[z] = w;
            z++;
        }
        return latin;
    }

    //97-122
    public static void validLatin(String string) throws LatinException {

        char[] latin = getLatin();

        char[] onlyLetters = string.replaceAll(INT_PLUS_BRACKET, "").replaceAll
                (CLOSE_BRACKET, "").toCharArray();

        int countOfMatches = 0;
        for (char currentLetter : onlyLetters) {
            for (char latinLetter : latin) {
                if(currentLetter == latinLetter){
                    countOfMatches++;
                }
            }
        }
        if (countOfMatches < onlyLetters.length){
            throw new LatinException("В строке должны быть только латинские буквы.");
        }
    }

    public static void validLatin2(String string) throws LatinException {
        Pattern pattern = Pattern.compile("[^a-z]");
        Matcher matcher = pattern.matcher(string);
        String s1 = "";
        String s2 = "";
        String s3 = "";
        String s4 = "";
        while (matcher.find()) {
            s1 += matcher.group();
        }

        pattern = Pattern.compile("[^\\d]");
        matcher = pattern.matcher(s1);
        while (matcher.find()) {
            s2 += matcher.group();
        }

        pattern = Pattern.compile("[^\\[]");
        matcher = pattern.matcher((s2));
        while (matcher.find()) {
            s3 += matcher.group();
        }

        pattern = Pattern.compile("[^\\]]");
        matcher = pattern.matcher((s3));
        while (matcher.find()) {
            s4 += matcher.group();
        }

        if (s4 != "") {
            throw new LatinException("В строке должны быть только латинские буквы.");
        }
    }

    public static void allValidation(String string) throws LatinException, DuoBracketException,
            SpaceException, DigitBracketException {
        Validator.validDuoBracket(string);
        Validator.validSpace(string);
        Validator.validLatin2(string);
        Validator.validDigitBracket(string);
    }
}
