package com.mitya;

public class Starter {
    public static void main(String[] args) {

        System.out.println("Программа началась.");
        UnPacker up = new UnPacker();
        up.unpackStringFromFile();
        System.out.println("Программа закончена.");
    }
}
