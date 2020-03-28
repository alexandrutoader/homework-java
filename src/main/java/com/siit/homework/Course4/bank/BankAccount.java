package com.siit.homework.Course4.bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String iban;
    private BigDecimal balance;
    private List<Card> attachedCardNumber;

    public BankAccount(String iban) {
        this.iban = iban;
        this.attachedCardNumber = new ArrayList<Card>();
    }

    public void addMoney(BigDecimal amount) throws Exception {
        BigDecimal amountDecimal = new BigDecimal(String.valueOf(amount));
        if (amountDecimal.compareTo(BigDecimal.ZERO) < 0) {
            throw new Exception("The amount should be greater than 0!");
        }

        if (null != this.balance) {
            BigDecimal currentAmount = this.balance;
            this.balance = amountDecimal.add(currentAmount);
        }
        this.balance = amountDecimal;
    }

    public void withdrawMoney(BigDecimal amount) throws Exception {
        BigDecimal amountDecimal = new BigDecimal(String.valueOf(amount));
        BigDecimal currentBalance = new BigDecimal(String.valueOf(this.balance));
        if (amountDecimal.compareTo(BigDecimal.ZERO) < 0) {
            throw new Exception("The amount should be greater than 0!");
        }

        if (amountDecimal.compareTo(currentBalance) > 0) {
            throw new Exception("Not enough money for this operation!");
        }

        this.balance = currentBalance.subtract(amountDecimal);
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
}
