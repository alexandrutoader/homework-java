package com.siit.homework.course11.streams;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class StreamExercises {
    //    3. Find all traders from Cambridge and sort them by name.
    //    4. Return a string of all traders’ names sorted alphabetically.
    //    5. Are any traders based in Milan?
    //    6. Print all transactions’ values from the traders living in Cambridge.
    //    7. What’s the highest value of all the transactions?
    //    8. Find the transaction with the smallest value.

    static Trader raoul = new Trader("Raoul", "Cambridge");

    static Trader mario = new Trader("Mario", "Milan");

    static Trader alan = new Trader("Alan", "Cambridge");

    static Trader brian = new Trader("Brian", "Cambridge");

    static Set<Trader> traders = Set.of(raoul, mario, alan, brian);

    static List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    public static void main(String[] args) {
        findAllTradersFromCambridge("Cambridge");
        System.out.println("\n");
        returnStringOfAllTraders();
        System.out.println("\n");
        findAllTradersBasedInMilan("Milan");
        System.out.println("\n");
        printAllTransactionsFromTradersLivingInCambridge("Cambridge");
        System.out.println("\n");
        findHighestValueOfAllTransactions();
        System.out.println("\n");
        findTransactionWithSmallestValue();
    }

    //    3. Find all traders from Cambridge and sort them by name.
    static Set<Trader> findAllTradersFromCambridge(String city) {
        traders.stream()
                .filter(trader -> trader.getCity().equals(city))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(toList())
                .forEach(System.out::println);

        return traders;
    }

    //    4. Return a string of all traders’ names sorted alphabetically.
    static Set<Trader> returnStringOfAllTraders() {
        traders.stream()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(toList())
                .forEach(System.out::println);

        return traders;
    }

    //    5. Are any traders based in Milan?
    static Set<Trader> findAllTradersBasedInMilan(String city) {
        traders.stream()
                .filter(trader -> trader.getCity().equals(city))
                .sorted(Comparator.comparing(Trader::getCity))
                .collect(toList())
                .forEach(System.out::println);

        return traders;
    }

    //    6. Print all transactions’ values from the traders living in Cambridge.
    static List<Transaction> printAllTransactionsFromTradersLivingInCambridge(String city) {
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals(city))
                .collect(toList())
                .forEach(System.out::println);

        return transactions;
    }

    //    7. What’s the highest value of all the transactions?
    static List<Transaction> findHighestValueOfAllTransactions() {
        Transaction biggestTransaction = transactions.stream()
                .max(Comparator.comparing(Transaction::getValue))
                .get();

        System.out.println(biggestTransaction.toString());

        return transactions;
    }

    //    8. Find the transaction with the smallest value.
    static List<Transaction> findTransactionWithSmallestValue() {
        Transaction biggestTransaction = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue))
                .get();

        System.out.println(biggestTransaction.toString());

        return transactions;
    }
}
