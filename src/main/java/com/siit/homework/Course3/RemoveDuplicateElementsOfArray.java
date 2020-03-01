package com.siit.homework.Course3;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveDuplicateElementsOfArray {

    public static void main(String[] args) {
        int elementsArrayNumber;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter numbers of elements you want in array:\n");

        elementsArrayNumber = scanner.nextInt();
        removeDuplicateElementsFromArray(elementsArrayNumber, scanner);
    }

    public static void removeDuplicateElementsFromArray(int elementsArrayNumber, Scanner scanner) {
        int i;
        int j;
        int[] numbers = new int[elementsArrayNumber];
        System.out.println("Enter all the elements:");

        for (i = 0; i < elementsArrayNumber; i++) {
            numbers[i] = scanner.nextInt();
        }

        int numbersLength = numbers.length;

        for (i = 0; i < numbersLength; i++) {
            for (j = i + 1; j < numbersLength; j++) {
                if (numbers[i] == numbers[j]) {
                    numbers[j] = numbers[numbersLength - 1];
                    numbersLength--;
                    j--;
                }
            }
        }

        int[] arrayWithUniqueElements = Arrays.copyOf(numbers, numbersLength);
        System.out.println("\nOriginal array : ");
        for (int value : numbers) {
            System.out.print(value + "\t");
        }

        System.out.println("\n\nList elements of array after removing duplicates : ");

        for (int value : arrayWithUniqueElements) {
            System.out.print(value + "\t");
        }

        System.out.println("\n");
    }
}
