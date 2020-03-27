package com.siit.homework.Course5.bank.Repository;

import com.siit.homework.Course5.bank.Entity.BankAccount;
import com.siit.homework.Course5.bank.Entity.Card;

import java.util.ArrayList;
import java.util.List;

public class BankAccountRepository {
    public static List<Card> cards = new ArrayList<>();
    public static List<BankAccount> bankAccounts = new ArrayList<>();

    public static List<Card> getCards() {
        return cards;
    }

    public static void setCards(List<Card> cards) {
        BankAccountRepository.cards = cards;
    }

    public static List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public static void setBankAccounts(List<BankAccount> bankAccounts) {
        BankAccountRepository.bankAccounts = bankAccounts;
    }
}
