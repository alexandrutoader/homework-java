package com.siit.homework.Course4.bank;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String iban;
    private long balance;
    private List<Card> attachedCardNumber;

    public BankAccount(String iban) {
        this.iban = iban;
        this.attachedCardNumber = new ArrayList<Card>();
    }

    public void addMoney(long amount) throws Exception {
        if (amount < 0) {
            throw new Exception("The amount should be greater than 0!");
        }

        this.balance = this.balance + amount;
    }

    public void withdrawMoney(long amount) throws Exception {
        if (amount < 0) {
            throw new Exception("The amount should be greater than 0!");
        }

        if (this.balance < amount) {
            throw new Exception("Not enough money for this operation!");
        }

        this.balance = this.balance - amount;
    }

    public void attachCard(Card card) {
        this.attachedCardNumber.add(card);
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public List<Card> getAttachedCardNumber() {
        return attachedCardNumber;
    }

    public void setAttachedCardNumber(List<Card> attachedCardNumber) {
        this.attachedCardNumber = attachedCardNumber;
    }
}
