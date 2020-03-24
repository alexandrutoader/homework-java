package com.siit.homework.Course5.stringManipulation;

import java.util.Scanner;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringToBeReversed = scanner.next();
        System.out.println("\n1. Reverse a given string:");
        reverseGivenString(stringToBeReversed);

        System.out.println("\n----------------------------");
        System.out.println("\n2. Print duplicates characters from string:");
        printDuplicateCharactersFromString("java");

        System.out.println("\n------------------------------");
        System.out.println("\n3. Check if string are anagrams:");
        String stringOne = "java";
        String stringTwo = "ajva";
        checkIfTwoStringsAreAnagrams(stringOne, stringTwo);

        System.out.println("\n------------------------------");
        System.out.println("\n4. Find all permutations of a string:");
        findAllPermutationsOfAString("ABC", "");

        System.out.println("\n\n-------------------------------");
        System.out.println("\n5. Check if a string contains only digits:");
        isDigitOnly("123java");

        System.out.println("\n----------------------------------");
        System.out.println("\n6. Print duplicates characters from a given string:");
        System.out.println("Enter a string:");
        String givenString = scanner.next();
        printDuplicateCharactersFromString(givenString);

        System.out.println("\n-------------------------------------");
        System.out.println("\n7. Count a number of vowels and consonants in a given string:");
        System.out.println("Enter a string:");
        String string = scanner.next();
        printNumberOfVowelsAndConsonants(string);

        System.out.println("\n--------------------------------------");
        System.out.println("\n8. Count the occurrence of a given character in a string");
        System.out.println("Enter a string:");
        String stringOccurence = scanner.next();
        printTheOccurenceOfAGivenString(stringOccurence);
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
        for (int i = 0; i < stringOneChars.length; i++) {
            if (stringOneChars[i] != stringTwoChars[i]) {
                System.out.println("The strings are not anagarams!");
                return;
            }
        }

        System.out.println("The strings are anagrams!");
    }

    private static void findAllPermutationsOfAString(String string, String permutation) {
        if (string.length() == 0) {
            System.out.print(permutation + ", ");
            return;
        }

        for (int i = 0; i < string.length(); i++) {
            char toAppendToPermutation = string.charAt(i);
            String remaining = string.substring(0, i) + string.substring(i + 1);

            findAllPermutationsOfAString(remaining, permutation + toAppendToPermutation);
        }
    }

    private static void isDigitOnly(final String string) {
        if (string.isEmpty()) {
            System.out.println("The string is empty!");
            return;
        }

        for (int i = 0; i < string.length(); i++) {
            if (!Character.isDigit(string.charAt(i))) {
                System.out.println("The string '" + string + "' doesn't contains only digits.");
                return;
            }
        }
        System.out.println("The string '" + string + "' contains digits only.");
    }

    private static void printNumberOfVowelsAndConsonants(String string) {
        int i;
        int vowels = 0;
        int consonants = 0;
        string = string.toLowerCase();

        for (i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if ((ch == 'a') || (ch == 'e') || (ch == 'i') || (ch == 'o') || (ch == 'u')) {
                vowels++;
            } else if (ch >= 'a' && ch <= 'z') {
                consonants++;
            }
        }

        System.out.println("\nThe number of vowels and consonants for " + string + " are:");
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    private static void printTheOccurenceOfAGivenString(String string) {
        int MAX_CHAR = 256;
        // Create an array of size 256 i.e. ASCII_SIZE
        int[] count = new int[MAX_CHAR];

        int stringLength = string.length();

        // Initialize count array index
        for (int i = 0; i < stringLength; i++) {
            count[string.charAt(i)]++;
        }

        // Create an array of given String size
        char[] ch = new char[string.length()];

        for (int i = 0; i < stringLength; i++) {
            ch[i] = string.charAt(i);
            int find = 0;
            for (int j = 0; j <= i; j++) {

                // If any matches found
                if (string.charAt(i) == ch[j])
                    find++;
            }

            if (find == 1) {
                System.out.println("The occurence number for '" +
                        string.charAt(i) + "' is: " + count[string.charAt(i)]);
            }
        }
    }
}
