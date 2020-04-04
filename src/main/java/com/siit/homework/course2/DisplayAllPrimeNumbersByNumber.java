package com.siit.homework.course2;

import java.util.Scanner;

public class DisplayAllPrimeNumbersByNumber {

    public static void main(String[] args) {
        //Display all prime numbers lower than a given number.

        StringBuilder primeNumbers = new StringBuilder();
        int number;
        int i;
        int count;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");

        int inputNumber = scanner.nextInt();

        for (number = 1; number <= inputNumber; number++) {
            count = 0;
            for (i = 2; i <= number / 2; i++) {
                if (number % i == 0) {
                    count++;
                    break;
                }
            }

            if (count == 0 && number != 1) {
                primeNumbers.append(number).append(", ");
            }
        }

        primeNumbers = new StringBuilder(primeNumbers.toString().replaceAll(", $", ""));

        System.out.println("All prime numbers lower than" + inputNumber + " are : " + primeNumbers);
    }
}
