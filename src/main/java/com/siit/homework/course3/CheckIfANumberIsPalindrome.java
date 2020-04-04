package com.siit.homework.course3;

import java.util.Scanner;

public class CheckIfANumberIsPalindrome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");

        int inputNumber = scanner.nextInt();
        isPalindrome(inputNumber);
    }

    public static void isPalindrome(int inputNumber) {
        int sum = 0;
        int result;
        int defaultInputValue = inputNumber;

        while (inputNumber > 0) {
            result = inputNumber % 10;
            sum = (sum * 10) + result;

            inputNumber = inputNumber / 10;
        }

        if (defaultInputValue == sum) {
            System.out.println("This number is a palindrome.");
        } else {
            System.out.println("This number is not a palindrome");
        }
    }
}
