package com.siit.homework.course3;

import java.util.Scanner;

public class CalculateAndDisplayFactorialOfNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter a number: ");
        int number = scanner.nextInt();

        if (number <= 0) {
            System.out.println("\nPlease provide a number greater than 0!");
            return;
        }

        displayFactorialOfNumber(number);
    }

    private static void displayFactorialOfNumber(int number) {
        long factorial = 1;
        StringBuilder iterateNumbers = new StringBuilder();

        for(int i = 1; i <= number; ++i)
        {
            factorial *= i;
            iterateNumbers.append(i).append("*");
        }

        iterateNumbers.deleteCharAt(iterateNumbers.length()-1);

        System.out.printf("Factorial of %d! = " + iterateNumbers + " = %d", number, factorial);
    }
}
