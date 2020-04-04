package com.siit.homework.course3;

import java.util.Scanner;

public class FindAllPairsInArrayWhereSumEqualToNumber {

    public static void main(String[] args) {
        int inputNumber;
        int i;
        int sumNumber;

        Scanner in = new Scanner(System.in);
        System.out.println("\nEnter sum number:");
        sumNumber = in.nextInt();

        System.out.println("\nEnter number of elements for array:");
        inputNumber = in.nextInt();
        int[] array = new int[inputNumber];

        System.out.println("\nEnter elements for array:");
        for (i = 0; i < inputNumber; i++) {
            array[i] = in.nextInt();
        }

        findPairs(array, sumNumber);
    }

    private static void findPairs(int[] inputArray, int inputNumber) {
        boolean pairs = false;
        System.out.println("\nPairs of elements whose sum is " + inputNumber + " are : ");

        for (int i = 0; i < inputArray.length; i++) {
            for (int j = i + 1; j < inputArray.length; j++) {
                if (inputArray[i] + inputArray[j] == inputNumber) {
                    System.out.println(inputArray[i] + " + " + inputArray[j] + " = " + inputNumber);
                    pairs = true;
                }
            }
        }

        if (!pairs) {
            System.out.println("No pairs of elements whose sum is equal to " + inputNumber + " were found in array!");
        }
    }
}
