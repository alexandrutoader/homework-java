package com.siit.homework.course2;

import java.util.Scanner;

public class DisplayMaxDigitFromNumber {

    public static void main(String[] args) {
        int number;
        int digit = 0;
        int result;
        int defaultNumber;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        number = scanner.nextInt();
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
