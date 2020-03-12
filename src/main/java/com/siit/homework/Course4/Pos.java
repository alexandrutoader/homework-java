package com.siit.homework.Course4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Pos {
    private List<BankAccount> bankAccounts;
    private long amount;

    public void addKnownBankAccounts(BankAccount bankAccount) {
        this.bankAccounts = new ArrayList<>();
        this.bankAccounts.add(bankAccount);
    }

    public String pay(long amount,Card card) throws Exception {
        this.amount = amount;
        String timeStamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
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

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
