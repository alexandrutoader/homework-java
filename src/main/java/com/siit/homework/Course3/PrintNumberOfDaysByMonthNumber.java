package com.siit.homework.Course3;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class PrintNumberOfDaysByMonthNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter month: ");

        int month = Integer.parseInt(scanner.next());

        printNUmberOfDaysByMonthNumber(month);
    }

    public static void printNUmberOfDaysByMonthNumber(int month) {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        boolean isLeapyear = new GregorianCalendar().isLeapYear(year);

        String februaryDays = "28 days";
        if (isLeapyear) {
            februaryDays = "29 days";
        }

        switch(month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("31 days");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("30 days");
                break;
            case 2:
                System.out.println(februaryDays);
                break;
            default:
                System.out.println("The input is not valid! Try a number between 1-12.");

        }
    }
}
