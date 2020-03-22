package com.siit.homework.Course5.stringManipulation;

import java.util.Scanner;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String string = scanner.next();

        System.out.println("\n1. Get string reversed:");
        reverseGivenString(string);

        System.out.println("\n----------------------------");

        System.out.println("\n2. Print duplicates characters from string:");
        printDuplicateCharactersFromString(string);

        System.out.println("\n------------------------------");
        System.out.println("\n3. Check if string are anagrams:");
        System.out.println("Enter string one:");
        String stringOne = scanner.next();
        System.out.println("Enter string two:");
        String stringTwo = scanner.next();
        checkIfTwoStringsAreAnagrams(stringOne, stringTwo);
    }

    private static void reverseGivenString(String string) {
        int i;
        StringBuilder reversedString = new StringBuilder();
        char[] character = string.toCharArray();

        for (i = character.length - 1; i >= 0; i--) {
            reversedString.append(character[i]);
        }

        System.out.println("Initial initialString: " + string);
        System.out.println("String reversed: " + reversedString);
    }

    private static void printDuplicateCharactersFromString(String string) {
        int i;
        int j;
        StringBuilder duplicateCharacters = new StringBuilder();
        char[] charactersFromString = string.toCharArray();

        for (i = 0; i < charactersFromString.length; i++) {
            for (j = i + 1; j < charactersFromString.length; j++) {
                if (charactersFromString[i] == charactersFromString[j]) {
                    duplicateCharacters.append(" ").append(charactersFromString[j]);
                    break;
                }
            }
        }

        System.out.println("String: " + string);
        System.out.println("Duplicate characters from string: " + duplicateCharacters);
    }

    private static void checkIfTwoStringsAreAnagrams(String stringOne, String stringTwo) {
        char[] stringOneChars = stringOne.toCharArray();
        char[] stringTwoChars = stringTwo.toCharArray();

        if (stringOneChars.length != stringTwoChars.length) {
            System.out.println("The strings are not anagrams!");
            return;
        }

        //Sort stringOneChars
        for (int i = 0; i < stringOneChars.length; i++) {
            for (int j = i + 1; j < stringOneChars.length; j++) {
                if (stringOneChars[i] >= stringOneChars[j]) {
                    char m = stringOneChars[i];
                    stringOneChars[i] = stringOneChars[j];
                    stringOneChars[j] = m;
                }
            }
        }

        //Sort stringTwoChars
        for (int i = 0; i < stringTwoChars.length; i++) {
            for (int j = i + 1; j < stringTwoChars.length; j++) {
                if (stringTwoChars[i] >= stringTwoChars[j]) {
                    char m = stringTwoChars[i];
                    stringTwoChars[i] = stringTwoChars[j];
                    stringTwoChars[j] = m;
                }
            }
        }

        //Check if the two string are equals or not.
        for (int i = 0; i < stringOneChars.length;i++) {
            if (stringOneChars[i] != stringTwoChars[i]) {
                System.out.println("The strings are not anagarams!");
                return;
            }
        }

        System.out.println("The strings are anagrams!");
    }
}
