package com.siit.homework.course3;

public class PrintFirstTwentyFiveFibonacci {

    public static void main(String[] args) {
        //Print first 25 terms of fibonacci series.
        printFirstTwentyFiveFibonacciNumbers();
    }

    private static void printFirstTwentyFiveFibonacciNumbers() {
        int first = 0;
        int second = 1;
        int i;

        System.out.println("\n");
        System.out.println("The first 25 fibonacci series numbers are: ");
        for (i = 1; i <= 25; i++) {
            System.out.print(second + " ");
            int next = first + second;
            first = second;
            second = next;
        }
        System.out.println("\n");
    }
}

