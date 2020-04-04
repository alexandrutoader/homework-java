package com.siit.homework.course5.bank.Entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Card> cards;
    private List<BankAccount> bankAccounts;

    public User() {
        this.cards = new ArrayList<Card>();
        this.bankAccounts = new ArrayList<BankAccount>();
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void addBankAccount(BankAccount bankAccount) {
        this.bankAccounts.add(bankAccount);
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}
