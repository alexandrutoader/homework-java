package com.siit.homework.course5.bank.Entity;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

public class Pos {
    private List<BankAccount> bankAccounts;
    private BigDecimal amount;

    public void addKnownBankAccounts(BankAccount bankAccount) {
        this.bankAccounts = new ArrayList<>();
        this.bankAccounts.add(bankAccount);
    }

    public String pay(BigDecimal amount, Card card) throws Exception {
        this.amount = amount;
        String timeStamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        if (bankAccounts.isEmpty()) {
            throw new Exception("No bank account found!");
        }
        for (BankAccount account : bankAccounts) {
            for (Card accountCard : account.getAttachedCardNumber()) {
                if (sdf.parse(timeStamp).after(sdf.parse(accountCard.getExpirationDate()))) {
                    throw new Exception("Card " + accountCard.getCardNumber() + " is expired!");
                }
                if (accountCard.getCardNumber() == card.getCardNumber()) {
                    account.withdrawMoney(amount);
                }
            }
        }

        return "Thank you for your payment! Please take your receipt!";
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Pos setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public boolean validateCard(Integer pinCode) throws Exception {
        String timeStamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        if (bankAccounts.isEmpty()) {
            System.out.println("No bank account found!");
            return false;
        }

        for (BankAccount account : bankAccounts) {
            for (Card accountCard : account.getAttachedCardNumber()) {
                if (account.getOwnerName().equals(accountCard.getOwnerName())) {
                    if (sdf.parse(timeStamp).after(sdf.parse(accountCard.getExpirationDate()))) {
                        System.out.println("Card " + accountCard.getCardNumber() + " is expired!");
                        return false;
                    }

                    if (!accountCard.getPinCode().equals(pinCode)) {
                        System.out.println("Incorrect pin code!");
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public void changePinCode(Integer pinCode) throws Exception {
        for (BankAccount account : bankAccounts) {
            for (Card accountCard : account.getAttachedCardNumber()) {
                if (account.getOwnerName().equals(accountCard.getOwnerName())) {
                    System.out.println("Please confirm again your pin code:");
                    Scanner scanner = new Scanner(System.in);
                    int pinConfirmation = scanner.nextInt();

                    while (pinConfirmation != pinCode) {
                        System.out.println("Confirmation pin is not matching with initial pin code!");
                        System.out.println("Enter confirmation pin again:");
                        int pinConfirmationRetry = scanner.nextInt();

                        if (pinConfirmationRetry == pinCode) {
                            pinConfirmation = pinConfirmationRetry;
                        }
                    }
                    accountCard.setPinCode(pinCode);
                }
            }
        }

    }
}
