package com.siit.homework.course5.bank.Entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String iban;
    private BigDecimal balance;
    private String ownerName;
    private List<Card> attachedCardNumber = new ArrayList<Card>();

    public BankAccount(String iban, BigDecimal balance, String ownerName) {
        this.iban = iban;
        this.balance = balance;
        this.ownerName = ownerName;
    }

    public BankAccount() {
    }

    public void addMoney(BigDecimal amount) throws Exception {
        BigDecimal amountDecimal = new BigDecimal(String.valueOf(amount));
        if (amountDecimal.compareTo(BigDecimal.ZERO) < 0) {
            throw new Exception("The amount should be greater than 0!");
        }
        BigDecimal currentAmount = this.balance;

        this.balance = currentAmount.add(amountDecimal);
    }

    public boolean withdrawMoney(BigDecimal amount) {
        BigDecimal amountDecimal = new BigDecimal(String.valueOf(amount));
        BigDecimal currentBalance = new BigDecimal(String.valueOf(this.balance));
        if (amountDecimal.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("The amount should be greater than 0!");
            return false;
        }

        if (amountDecimal.compareTo(currentBalance) > 0) {
            System.out.println("Not enough money for this operation!");
            return false;
        }

        this.balance = currentBalance.subtract(amountDecimal);
        return true;
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

    public BigDecimal getBalance() {
        return balance;
    }

    public BankAccount setBalance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }

    public List<Card> getAttachedCardNumber() {
        return attachedCardNumber;
    }

    public void setAttachedCardNumber(List<Card> attachedCardNumber) {
        this.attachedCardNumber = attachedCardNumber;
    }

    public void addBankAccount(String iban, BigDecimal balance, String ownerName) {
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
