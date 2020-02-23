package com.siit.homework.Course2;

import java.util.Scanner;

public class DisplayMaxDigitFromNumber {

    public static void main(String[] args) {
        int number;
        int digit = 0;
        int r;
        int defaultNumber;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        number = scanner.nextInt();
        defaultNumber = number;


        while (number > 0) {
            r = number % 10;

            if (digit < r) {
                digit = r;
            }

            number = number / 10;
        }

        System.out.println("\nThe max digit for number " + defaultNumber + " is: " + digit);
    }
}
