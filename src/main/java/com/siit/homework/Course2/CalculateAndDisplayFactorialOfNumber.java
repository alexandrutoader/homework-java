package com.siit.homework.Course2;

import java.util.Scanner;

public class CalculateAndDisplayFactorialOfNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();

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
