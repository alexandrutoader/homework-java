package com.siit.homework.Course5.bank.Entity;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String iban;
    private long balance;
    private String ownerName;
    private List<Card> attachedCardNumber = new ArrayList<Card>();

    public BankAccount(String iban, Long balance, String ownerName) {
        this.iban = iban;
        this.balance = balance;
        this.ownerName = ownerName;
    }

    public BankAccount() {
    }

    public void addMoney(long amount) throws Exception {
        if (amount < 0) {
            throw new Exception("The amount should be greater than 0!");
        }

        this.balance = this.balance + amount;
    }

    public void withdrawMoney(long amount) {
        if (amount < 0) {
            System.out.println("The amount should be greater than 0!");
        }

        if (this.balance < amount) {
            System.out.println("Not enough money for this operation!");
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

    public void addBankAccount(String iban, Long balance, String ownerName) {
        this.iban = iban;
        this.balance = balance;
        this.ownerName = ownerName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
