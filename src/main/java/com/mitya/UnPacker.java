package com.mitya;

import exception.DigitBracketException;
import exception.DuoBracketException;
import exception.LatinException;
import exception.SpaceException;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnPacker {

    private static final String REGEX_FOR_MULTIPLY = "\\[\\w+\\]";
    private static final String BASIC_REGEX = "\\d+\\[\\w+\\]";

    public String unpackStringFromFile() {
        String in = readFromFile();
        try {
            Validator.allValidation(in);
        } catch (DigitBracketException e) {
            e.printStackTrace();
        } catch (DuoBracketException e) {
            e.printStackTrace();
        } catch (LatinException e) {
            e.printStackTrace();
        } catch (SpaceException e) {
            e.printStackTrace();
        }

        Pattern pattern = Pattern.compile(BASIC_REGEX);

        while (true) {
            Matcher matcher = pattern.matcher(in);
            if (!matcher.find()) {
                break;
            }
            String s1 = multiply(matcher.group());
            in = matcher.replaceFirst(s1);
        }
        writeIntoFile(in);
        return in;
    }



    private String readFromFile() {
        StringBuilder sb = new StringBuilder();

        try (FileInputStream is = new FileInputStream
                ("C:/Users/Dima/IdeaProjects/UnPackString/src/main/resources/input.txt");
             InputStreamReader reader = new InputStreamReader(is)) {

            while (true) {
                int simbol = reader.read();
                if (simbol == -1) {
                    break;
                }
                sb.append((char) simbol);
            }
        } catch (IOException n) {
            System.out.println(n.getMessage());
            n.printStackTrace();
            throw new RuntimeException();
        }
        return sb.toString().toLowerCase();
    }

    private String multiply(String sub) {
        int ratio = Integer.parseInt(sub.replaceAll(REGEX_FOR_MULTIPLY, ""));
        return sub.substring(sub.indexOf('[') + 1, sub.indexOf(']')).repeat(ratio);
    }


    private void writeIntoFile(String unpacked) {
        try (FileOutputStream os = new FileOutputStream("src\\main\\resources\\output.txt");
             OutputStreamWriter writer = new OutputStreamWriter(os)) {
            writer.write(unpacked);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
