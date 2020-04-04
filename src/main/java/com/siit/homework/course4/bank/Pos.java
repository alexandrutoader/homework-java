package com.siit.homework.course4.bank;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        for (BankAccount account:bankAccounts) {
            for (Card accountCard: account.getAttachedCardNumber()) {
                if (sdf.parse(timeStamp).after(sdf.parse(accountCard.getExpirationDate()))) {
                    throw new Exception("Card " + accountCard.getCardNumber() + " is expired!");
                }
                if(accountCard.getCardNumber() == card.getCardNumber()){
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
}
