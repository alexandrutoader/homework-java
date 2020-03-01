package com.siit.homework.Course3;

import java.util.Scanner;

public class DisplayMaxDigitFromNumber {

    public static void main(String[] args) {
        int number;
        int digit = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        number = scanner.nextInt();

        displayMaxDigitFromNumber(number, digit);
    }

    public static void displayMaxDigitFromNumber(int number, int digit) {
        int defaultNumber;
        int result;
        defaultNumber = number;


        while (number > 0) {
            result = number % 10;

            if (digit < result) {
                digit = result;
            }

            number = number / 10;
        }

        System.out.println("\nThe max digit for number " + defaultNumber + " is: " + digit);
    }
}
