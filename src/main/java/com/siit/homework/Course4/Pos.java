package com.siit.homework.Course4;

import java.util.ArrayList;
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
        for (BankAccount account:bankAccounts) {
            for (Card accountCard: account.getAttachedCardNumber()) {
                if(accountCard.getCardNumber() == card.getCardNumber()){
                    account.withdrawMoney(amount);
                }
            }
        }

        String receipt =  "Thank you for your payment! Please take your receipt!";
        return receipt;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
