package com.siit.homework.course6;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
public class StringManipulation {
    final static int MAX_CHAR = 256;

    public String reverseGivenString(String string) {
        int i;
        StringBuilder reversed = new StringBuilder();
        char[] character = string.toCharArray();

        for (i = character.length - 1; i >= 0; i--) {
            reversed.append(character[i]);
        }

        System.out.println("Initial initialString: " + string);
        System.out.println("String reversed: " + reversed);
        return reversed.toString();
    }

    public String printDuplicateCharactersFromString(String string) {
        if (null == string) {
            return null;
        }
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
        return duplicateCharacters.toString().trim();
    }

    public String checkIfTwoStringsAreAnagrams(String stringOne, String stringTwo) {
        if (stringOne == null || stringTwo == null) {
            return null;
        }
        char[] stringOneChars = stringOne.toCharArray();
        char[] stringTwoChars = stringTwo.toCharArray();

        if (stringOneChars.length != stringTwoChars.length) {
            System.out.println("The strings are not anagrams!");
            return "The strings are not anagrams!";
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
                System.out.println("The strings are not anagrams!");
                return "The strings are not anagrams!";
            }
        }

        System.out.println("First string: " + stringOne);
        System.out.println("Second string: " + stringTwo);
        System.out.println("The strings are anagrams!");
        return "The strings are anagrams!";
    }

    public void findAllPermutationsOfAString(String string, String permutation) {
        if (string.length() == 0) {
            System.out.print(permutation + ", ");
        }

        for (int i = 0; i < string.length(); i++) {
            char toAppendToPermutation = string.charAt(i);
            String remaining = string.substring(0, i) + string.substring(i + 1);

            findAllPermutationsOfAString(remaining, permutation + toAppendToPermutation);
        }
    }

    public String isDigitOnly(String string) {
        if (null == string) {
             return null;
        }
        if (string.isEmpty()) {
            System.out.println("The string is empty!");
            return "The string is empty!";
        }

        for (int i = 0; i < string.length(); i++) {
            if (!Character.isDigit(string.charAt(i))) {
                System.out.println("The string '" + string + "' doesn't contains only digits.");
                return "The string '" + string + "' doesn't contains only digits.";
            }
        }
        System.out.println("The string '" + string + "' contains digits only.");
        return "The string '" + string + "' contains digits only.";
    }

    public List<Integer> printNumberOfVowelsAndConsonants(String string) {
        int i;
        int vowels = 0;
        int consonants = 0;
        List<Integer>stringElements = new ArrayList<>();

        if (string == null) {
            return  null;
        }

        if (string.isEmpty()) {
            return  stringElements;
        }
        string = string.toLowerCase();

        for (i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if ((ch == 'a') || (ch == 'e') || (ch == 'i') || (ch == 'o') || (ch == 'u')) {
                vowels++;
            } else if (ch >= 'a' && ch <= 'z') {
                consonants++;
            }
        }
        System.out.println("\nThe number of vowels and consonants for '" + string + "' are:");
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        stringElements.add(vowels);
        stringElements.add(consonants);
        return stringElements;
    }

    public HashMap<Character, Integer> printTheOccurenceOfAGivenString(String string) {
        HashMap<Character, Integer> map = new HashMap<>();
        int[] count = new int[MAX_CHAR];

        if (string == null) {
            return null;
        }

        if (string.isEmpty()) {
            return map;
        }
        int stringLength = string.length();

        for (int i = 0; i < stringLength; i++) {
            count[string.charAt(i)]++;
        }

        char[] ch = new char[string.length()];

        for (int i = 0; i < stringLength; i++) {
            ch[i] = string.charAt(i);
            int find = 0;
            for (int j = 0; j <= i; j++) {
                if (string.charAt(i) == ch[j])
                    find++;
            }

            if (find == 1) {
                System.out.println("The occurence number for '" +
                        string.charAt(i) + "' is: " + count[string.charAt(i)]);
                map.put(string.charAt(i), count[string.charAt(i)]);
            }
        }
        return map;
    }

    public String findFirstNonRepeatingCharacter(String string) {
        if (null == string) {
            return "";
        }

        if (string.isEmpty()) {
            return "";
        }
        System.out.println("The given string is: " + string);
        for (int i = 0; i < string.length(); i++) {
            boolean unique = true;
            for (int j = 0; j < string.length(); j++) {
                if (i != j && string.charAt(i) == string.charAt(j)) {
                    unique = false;
                    break;
                }
            }
            if (unique) {
                System.out.println("The first non repeated character in string is: " + string.charAt(i));
                return "The first non repeated character in string is: " + string.charAt(i);
            }
        }
        return "";
    }

    public Number printStringToInt(String string) {
        int i = 0;
        int number = 0;
        boolean isNegative = false;

        if (null == string) {
            return null;
        }

        if (string.isEmpty()) {
            return 0;
        }

        if (string.charAt(0) == '-') {
            isNegative = true;
            i = 1;
        }

        while (i < string.length()) {
            number *= 10;
            number += string.charAt(i++) - '0'; //Minus the ASCII code of '0'.
        }

        if (isNegative)
            number = -number;

        System.out.println("Given string: " + string);
        System.out.println("String to int: " + number);
        return number;
    }

    public String reverseWordsFromSentence(String string) {
        if (null == string) {
            return null;
        }
        String[] sentence = string.split(" ");
        StringBuilder sentenceReversed = new StringBuilder();
        for (int i = sentence.length - 1; i >= 0; i--) {
            sentenceReversed.append(sentence[i]).append(" ");
        }
        System.out.println("Initial sentence: " + string);
        System.out.println("Reversed sentence: " + sentenceReversed.substring(0, sentenceReversed.length() - 1));
        return "Reversed sentence: " + sentenceReversed.substring(0, sentenceReversed.length() - 1);
    }

    public String isRotation(String str1, String str2) {
        if ((null == str1) || (null == str2)) {
            return null;
        }
        if (str1.length() != str2.length()) {
            System.out.println("The input strings are: 1)" + str1 + " 2) " + str2);
            System.out.println("The two strings are not a rotation of each other.");
            return "The two strings are not a rotation of each other.";
        }
        String concatenated = str1 + str1;

        if (concatenated.contains(str2)) {
            System.out.println("The input strings are: 1)" + str1 + " 2) " + str2);
            System.out.println("The two strings are a rotation of each other.");
            return "The two strings are a rotation of each other.";
        }
        System.out.println("The input strings are: 1)" + str1 + " 2) " + str2);
        System.out.println("The two strings are not a rotation of each other.");
        return "The two strings are not a rotation of each other.";
    }

    public String stringIsPalindrome(String string) {
        if (null == string) {
            return null;
        }
        String clean = string.replaceAll("\\s+", "").toLowerCase();
        int length = clean.length();
        int forward = 0;
        int backward = length - 1;
        while (backward > forward) {
            char forwardChar = clean.charAt(forward++);
            char backwardChar = clean.charAt(backward--);
            if (forwardChar != backwardChar) {
                System.out.println("Input string: " + string);
                System.out.println("The string is not a palindrome.");
                return "The string is not a palindrome.";
            }
        }
        System.out.println("Input string: " + string);
        System.out.println("The string is a palindrome.");
        return "The string is a palindrome.";
    }

    public String longestSubstringWithoutRepeatingChars(String string) {
        if (null == string) {
            return null;
        }

        String stringWithoutRepeating = "";
        for (int i = 0; i < string.length(); i++) {
            if (stringWithoutRepeating.indexOf(string.charAt(i)) < 0) {
                stringWithoutRepeating = stringWithoutRepeating + string.charAt(i);
            }
        }

        System.out.println("Initial string: " + string);
        System.out.println("Word without reapeating: " + stringWithoutRepeating);
        System.out.println("The length of the longest substring is " + stringWithoutRepeating.length());
        return "The length of the longest substring is " + stringWithoutRepeating.length();
    }

    public String findLongestPalindromeSubstring(String str) {
        if (null == str) {
            return null;
        }

        int n = str.length();
        int longestSoFar = 0;
        int startIndex = 0;
        int endIndex = 0;

        if (str.isEmpty()) {
            System.out.println("The input is empty!");
            return "The input is empty!";
        }

        boolean[][] palindrome = new boolean[n][n];

        for (int j = 0; j < n; j++) {
            palindrome[j][j] = true;
            for (int i = 0; i < j; i++) {
                if (str.charAt(i) == str.charAt(j) && (j - i <= 2 || palindrome[i + 1][j - 1])) {
                    palindrome[i][j] = true;
                    if (j - i + 1 > longestSoFar) {
                        longestSoFar = j - i + 1;
                        startIndex = i;
                        endIndex = j;
                    }
                }
            }
        }
        System.out.println("The longest palindrome from string '" + str + "' is: " + str.substring(startIndex, endIndex + 1) + ".");
        return "The longest palindrome from string '" + str + "' is: " + str.substring(startIndex, endIndex + 1) + ".";
    }

    public String removeDuplicateCharactersFromString(String str) {
        if (null == str) {
            return null;
        }

        if (str.isEmpty()) {
            return "";
        }
        char[] c = str.toCharArray();
        StringBuilder op = new StringBuilder();

        for (int i = 0; i <= c.length - 1; i++) {
            if (!op.toString().contains(c[i] + ""))
                op.append(c[i]);
        }
        System.out.println("Initial string: " + str);
        System.out.println("String after removing characters:" + op);
        return "String after removing characters: " + op;
    }

    public String removeAGivenCharacterFromString(String str, char c) {
        if (null == str) {
            return null;
        }
        if (str.isEmpty()) {
            System.out.println("The string is empty!");
            return "";
        }

        StringBuilder strBuilder = new StringBuilder();
        char[] removedString = str.toCharArray();

        for (char value : removedString) {
            if (value != c) {
                strBuilder.append(value);
            }
        }

        System.out.println("Initial string: " + str);
        System.out.println("String after removing duplicate chars: " + strBuilder.toString());
        return "String after removing duplicate chars: " + strBuilder.toString();
    }

    public String findMostFrequentWordInArray(String str) {
        if (str == null) {
            return null;
        }
        String[] words = str.split("\\s+");
        int finalCount = 0;
        int tempCount = 0;
        String mostlyUsedWord = null;

        for (String word : words) {
            tempCount = 0;
            for (String w : words) {
                if (word.equalsIgnoreCase(w)) {
                    tempCount++;
                }
            }

            if (tempCount >= finalCount) {
                finalCount = tempCount;
                mostlyUsedWord = word;
            }
        }

        System.out.println("Most frequent word in array: " + mostlyUsedWord);
        return "Most frequent word in array: " + mostlyUsedWord;
    }
}
