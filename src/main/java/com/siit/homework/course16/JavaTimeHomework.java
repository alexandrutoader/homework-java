package com.siit.homework.course16;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

public class JavaTimeHomework {
    public static void main(String[] args) throws ParseException {
        getMonthsDaysOfYear(2020);
        listAllMondaysFromAGivenMonth("january");
        checkIfGivenDateOccursOnFridayThe13th("30.12.2020");
    }

    public static void getMonthsDaysOfYear(int year) {
        System.out.println("Write a method that, for a given year, reports the length of each month within that year.");
        try {
            if (year < 0) {
                throw new IllegalArgumentException("Please provide a year greater than 0!");
            }
            for (int month = 1; month <= 12; month++) {
                YearMonth yearMonth = YearMonth.of(year, Month.of(month));
                System.out.printf("%s: %d%n", yearMonth, yearMonth.lengthOfMonth());
            }
        } catch (RuntimeException e) {
            System.out.println("Error occured: " + e.getMessage());
        }
        System.out.println("\n");
    }

    public static void listAllMondaysFromAGivenMonth(String monthInput) {
        System.out.println("Write a method that, for a given month of the current year, lists all of the Mondays in that month.");
        Month month = Month.valueOf(monthInput.toUpperCase());

        System.out.printf("For the month of %s:%n", month);
        LocalDate date = Year.now().atMonth(month).atDay(1).
                with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        Month mi = date.getMonth();
        while (mi == month) {
            System.out.printf("%s%n", date);
            date = date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
            mi = date.getMonth();
        }
        System.out.println("\n");
    }

    public static void checkIfGivenDateOccursOnFridayThe13th(String dateString) throws ParseException {
        System.out.println("Write an example that tests whether a given date occurs on Friday the 13th.");
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = dateFormat.parse(dateString);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int counter = 0;
        int months = 0;
        while(months++ <= 12){
            if(Calendar.FRIDAY == cal.get(Calendar.DAY_OF_WEEK)){
                counter++;
            }
            cal.add(Calendar.MONTH, 1);
        }

        System.out.println("Number of Fridays on 13th = "+ counter);
    }
}
