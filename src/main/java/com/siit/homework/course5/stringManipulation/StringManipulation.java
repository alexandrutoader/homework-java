package com.siit.homework.course5.stringManipulation;

public class StringManipulation {
    final static int MAX_CHAR = 256;

    public static void main(String[] args) {
        System.out.println("\n1. Reverse a given string:");
        reverseGivenString("scoalainformala");

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
        findAllPermutationsOfAString("test", "");

        System.out.println("\n\n-------------------------------");
        System.out.println("\n5. Check if a string contains only digits:");
        isDigitOnly("123java");

        System.out.println("\n----------------------------------");
        System.out.println("\n6. Print duplicates characters from a given string:");
        printDuplicateCharactersFromString("scoalainformala");

        System.out.println("\n-------------------------------------");
        System.out.println("\n7. Count a number of vowels and consonants in a given string:");
        printNumberOfVowelsAndConsonants("research");

        System.out.println("\n--------------------------------------");
        System.out.println("\n8. Count the occurrence of a given character in a string");
        printTheOccurenceOfAGivenString("stringOccurence");

        System.out.println("\n---------------------------------------");
        System.out.println("\n9. Print the first non-repeated character from a string:");
        findFirstNonRepeatingCharacter("scoalainformaladeit");

        System.out.println("\n----------------------------------------");
        System.out.println("\n10. Convert a given String into int:");
        printStringToInt("java");

        System.out.println("\n------------------------------------------");
        System.out.println("\n 11. Reverse words in a given sentence:");
        reverseWordsFromSentence("ana are mere");

        System.out.println("\n-------------------------------------------");
        System.out.println("\n12. Check if two strings are a rotation of each other:");
        isRotation("java", "avaj");

        System.out.println("\n----------------------------------------------");
        System.out.println("\n13. Check if a string is a palindrome:");
        stringIsPalindrome("capac");

        System.out.println("\n----------------------------------------------------");
        System.out.println("\n14. Find the length of the longest substring without repeating characters:");
        longestSubstringWithoutRepeatingChars("developer");

        System.out.println("\n----------------------------------------------------");
        System.out.println("\n15. Find the longest palindromic substring in str:");
        findLongestPalindromeSubstring("capacanasana");

        System.out.println("\n-----------------------------------------------------");
        System.out.println("\n16. Remove the duplicate character from String:");
        removeDuplicateCharactersFromString("scoalainformaladeit");

        System.out.println("\n------------------------------------------------------");
        System.out.println("\n17. Remove a given character from string:");
        removeAGivenCharacterFromString("developer", 'e');

        System.out.println("\n-------------------------------------------------------");
        System.out.println("\n18. Given an array of strings, find the most frequent word in a given array:");
        findMostFrequentWordInArray();
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

        System.out.println("First string: " + stringOne);
        System.out.println("Second string: " + stringTwo);
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

        System.out.println("\nThe number of vowels and consonants for '" + string + "' are:");
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    private static void printTheOccurenceOfAGivenString(String string) {
        int[] count = new int[MAX_CHAR];
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
            }
        }
    }

    private static void findFirstNonRepeatingCharacter(String string) {
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
                break;
            }
        }
    }

    private static void printStringToInt(String string) {
        int i = 0;
        int number = 0;
        boolean isNegative = false;

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
    }

    private static void reverseWordsFromSentence(String string) {
        String[] sentence = string.split(" ");
        StringBuilder sentenceReversed = new StringBuilder();
        for (int i = sentence.length - 1; i >= 0; i--) {
            sentenceReversed.append(sentence[i]).append(" ");
        }
        System.out.println("Initial sentence: " + string);
        System.out.println("Reversed sentence: " + sentenceReversed.substring(0, sentenceReversed.length() - 1));
    }

    private static void isRotation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            System.out.println("The input strings are: 1)" + str1 + " 2) " + str2);
            System.out.println("The two strings are not a rotation of each other.");
            return;
        }
        String concatenated = str1 + str1;

        if (concatenated.contains(str2)) {
            System.out.println("The input strings are: 1)" + str1 + " 2) " + str2);
            System.out.println("The two strings are a rotation of each other.");
            return;
        }
        System.out.println("The input strings are: 1)" + str1 + " 2) " + str2);
        System.out.println("The two strings are not a rotation of each other.");
    }

    public static void stringIsPalindrome(String string) {
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
                return;
            }
        }
        System.out.println("Input string: " + string);
        System.out.println("The string is a palindrome.");
    }

    public static void longestSubstringWithoutRepeatingChars(String string) {
        String stringWithoutRepeating = "";
        for (int i = 0; i < string.length(); i++) {
            if (stringWithoutRepeating.indexOf(string.charAt(i)) < 0) {
                stringWithoutRepeating = stringWithoutRepeating + string.charAt(i);
            }
        }

        System.out.println("Initial string: " + string);
        System.out.println("Word without reapeating: " + stringWithoutRepeating);
        System.out.println("The length of the longest substring is " + stringWithoutRepeating.length());
        ;
    }

    private static void findLongestPalindromeSubstring(String str) {
        int n = str.length();
        int longestSoFar = 0;
        int startIndex = 0;
        int endIndex = 0;

        if (str.isEmpty()) {
            System.out.println("The input is empty!");
            return;
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
    }

    public static void removeDuplicateCharactersFromString(String str) {
        char[] c = str.toCharArray();
        StringBuilder op = new StringBuilder();

        for (int i = 0; i <= c.length - 1; i++) {
            if (!op.toString().contains(c[i] + ""))
                op.append(c[i]);
        }
        System.out.println("Initial string: " + str);
        System.out.println("String after removing characters:" + op);
    }

    public static void removeAGivenCharacterFromString(String str, char c) {
        if (str.isEmpty()) {
            System.out.println("The string is empty!");
            return;
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
    }

    public static void findMostFrequentWordInArray() {
        String str = "def def def abc abc";
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
    }
}
