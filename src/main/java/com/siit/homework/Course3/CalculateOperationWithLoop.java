package com.siit.homework.Course3;

import java.util.Scanner;

public class CalculateOperationWithLoop {
    public static void main(String[] args) {
        int i = 1;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceti numarul de operatii de calcul pe care doriti sa le executati: ");
        int operations = scanner.nextInt();

        calculateOperation(i, scanner, operations);
    }

    public static void calculateOperation(int i, Scanner scanner, int operations) {
        while (i <= operations) {
            System.out.println("Introduceti numerele: ");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println("Introduceti operatia: ");
            String operation = scanner.next();

            switch (operation) {
                case "+":
                    System.out.println(a + " + " + b + " = " + (a + b));
                    break;
                case "-":
                    System.out.println(a + " - " + b + " = " + (a - b));
                    break;

                case "*":
                    System.out.println(a + " * " + b + " = " + a * b);
                    break;

                case "/":
                    System.out.println(a + " / " + b + " = " + (a / b));
                    break;

                default:
                    System.out.println("Bad operation!!!");
            }
            i++;
        }
    }
}
