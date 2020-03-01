package com.siit.homework.Course3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindDuplicatesCharctersInString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String string = scanner.next();

        findDuplicateCharacters(string);
    }

    public static void findDuplicateCharacters(String string) {
        char[] arrayOfChars = string.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : arrayOfChars) {
            if (map.containsKey(c)) {
                int counter = map.get(c);
                map.put(c, ++counter);
            } else {
                map.put(c, 1);
            }
        }

        System.out.println("The duplicate characters are:");

        for (char c : map.keySet()) {
            if (map.get(c) > 1) {
                System.out.println(c);
            }
        }
    }
}
