package com.siit.homework.Course3;

import java.util.Scanner;

public class CalculateOperationWithIfElse {

    public static void main(String... args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numerele: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println("Introduceti operatia: ");
        String operation = scanner.next();

        calculateOperation(a, b, operation);
    }

    public static void calculateOperation(int a, int b, String operation) {
        if (operation.equals("+")) {
            System.out.println(a + " + " + b + " = " + (a + b));
        } else if (operation.equals("-")) {
            System.out.println(a + " - " + b + " = " + (a - b));
        } else if (operation.equals("*")) {
            System.out.println(a + " * " + b + " = " + a * b);
        } else if (operation.equals("/")) {
            System.out.println(a + " / " + b + " = " + (a / b));
        } else {
            System.out.println("Bad operation!!!");
        }
    }
}
