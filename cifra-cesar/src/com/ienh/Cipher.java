package com.ienh;

import java.util.Random;

public class Cipher {

    private int START_INTEGER = 0;
    private final int MAX_KEY_SIZE = 100;
    private final String BASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZÁÉÍÓÃÕÂÔÇabcdefghijklmnopqrstuvwxyzáéíóãõâôç 1234567890!@#$&*()_-+=,.;:><?";
    private Random random = new Random();
    private String result;

    public ResultEncryptDTO encryptCesar(String text) {

        result = "";
        int startKey = random.nextInt(MAX_KEY_SIZE);
        int tempKey = startKey;

        for (int index = START_INTEGER; index < text.length(); index++) {

            int currentKey;
            char charCurrent = text.charAt(index);

            if (tempKey <= BASE_CHARS.length()) {
                currentKey = tempKey++;
                result += BASE_CHARS.charAt((BASE_CHARS.indexOf(charCurrent) + currentKey) % BASE_CHARS.length());
                System.out.println("currentKey in encrypt: " + currentKey);

            } else {
                tempKey = START_INTEGER;
                result += BASE_CHARS.charAt((BASE_CHARS.indexOf(charCurrent) + tempKey) % BASE_CHARS.length());
                System.out.println("currentKey in encrypt: " + tempKey);
            }
        }
        return new ResultEncryptDTO(result, startKey);
    }

    public String decryptCesar(String text, int key) {
        result = "";

        for (int index = START_INTEGER; index < text.length(); index++) {
            char charCurrent = text.charAt(index);
            int currentKey;

            if (key <= BASE_CHARS.length()) {
                currentKey = key++;
                result += BASE_CHARS.indexOf(charCurrent) - currentKey < START_INTEGER
                        ? indexSmallerZero(currentKey, charCurrent)
                        : indexBiggerZero(currentKey, charCurrent);

                System.out.println("currentKey in decrypt: " + currentKey);

            } else {
                key = START_INTEGER;
                result += indexBiggerZero(key, charCurrent);
                System.out.println("currentKey in decrypt: " + key);
            }
        }
        return result;
    }

    private char indexBiggerZero(int key, char charCurrent) {
        return BASE_CHARS.charAt((BASE_CHARS.indexOf(charCurrent) - key) % BASE_CHARS.length());
    }

    private char indexSmallerZero(int key, char charCurrent) {
        return BASE_CHARS.charAt((BASE_CHARS.indexOf(charCurrent) - key + BASE_CHARS.length()) % BASE_CHARS.length());
    }
}
