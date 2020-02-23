package com.siit.homework.Course2;

import com.sun.tools.javac.util.StringUtils;

public class CalculateSumOfPrimeNumbers {

    public static void main(String[] args) {
        System.out.println(calculateSumOfFirstHundredPrimeNumbers());
        System.out.println(getFirstHundredPrimeNumbers());
    }

    public static String calculateSumOfFirstHundredPrimeNumbers()
    {
        //Calculate the sum of the first 100 prime numbers.

        int sum = 0;
        int number;
        int i;
        int count;

        for (number = 1; number <= 100; number++) {
            count = 0;
            for (i = 2; i <= number / 2; i++) {
                if (number % i == 0) {
                    count++;
                    break;
                }
            }

            if (count == 0 && number != 1) {
                sum = sum + number;
            }
        }

        return "The sum of the first 100 prime numbers are: " + sum;
    }

    public static String getFirstHundredPrimeNumbers()
    {
        //Get first 100 prime numbers.

        StringBuilder primeNumbers = new StringBuilder();
        int number;
        int i;
        int count;

        for (number = 1; number <= 100; number++) {
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

        return "The first 100 prime numbers are: " + primeNumbers;
    }
}
