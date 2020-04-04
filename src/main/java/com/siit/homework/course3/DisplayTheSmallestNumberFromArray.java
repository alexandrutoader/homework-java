package com.siit.homework.course3;

import java.util.Scanner;

public class DisplayTheSmallestNumberFromArray {

    public static void main(String[] args) {
        System.out.println(displayTheSmallestNumberFromArrayWithFor());
        System.out.println(displayTheSmallestNumberFromArrayWithForeach());
    }

    public static String displayTheSmallestNumberFromArrayWithFor() {
        int elementsArrayNumber;
        int sum = 0;
        int i;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter numbers of elements you want in array:\n");

        elementsArrayNumber = scanner.nextInt();
        int[] numbers = new int[elementsArrayNumber];
        System.out.println("Enter all the elements:");

        for (i = 0; i < elementsArrayNumber; i++) {
            numbers[i] = scanner.nextInt();
            sum = sum + numbers[i];
        }

        int smallestNumber = numbers[0];

        for (i = 0; i < numbers.length; i++) {
            if (smallestNumber > numbers[i]) {
                smallestNumber = numbers[i];
            }
        }

        return "The smallest number from array is " + smallestNumber;
    }

    public static String displayTheSmallestNumberFromArrayWithForeach()
    {
        int elementsArrayNumber;
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter numbers of elements you want in array:\n");

        elementsArrayNumber = scanner.nextInt();
        int[] numbers = new int[elementsArrayNumber];
        System.out.println("Enter all the elements:");

        for (int i = 0; i < elementsArrayNumber; i++) {
            numbers[i] = scanner.nextInt();
            sum = sum + numbers[i];
        }

        int smallestNumber = numbers[0];

        for (int number : numbers) {
            if (smallestNumber > number) {
                smallestNumber = number;
            }
        }

        return "The smallest number from array is " + smallestNumber;
    }
}
